package team.gutterteam123.ledanimation.handlers;

import io.github.splotycode.mosaik.util.Pair;
import io.github.splotycode.mosaik.webapi.handler.anotation.check.Mapping;
import io.github.splotycode.mosaik.webapi.handler.anotation.check.NeedPermission;
import io.github.splotycode.mosaik.webapi.handler.anotation.handle.RequiredGet;
import io.github.splotycode.mosaik.webapi.request.Request;
import io.github.splotycode.mosaik.webapi.response.Response;
import io.github.splotycode.mosaik.webapi.response.content.ResponseContent;
import io.github.splotycode.mosaik.webapi.response.content.file.FileResponseContent;
import io.github.splotycode.mosaik.webapi.response.content.manipulate.pattern.PatternCommand;
import io.github.splotycode.mosaik.webapi.server.netty.NettyRequest;
import io.netty.channel.ChannelHandlerContext;
import team.gutterteam123.ledanimation.devices.*;

import java.io.File;
import java.util.stream.Collectors;

@NeedPermission
public class LiveHandler {

    @Mapping("views/live")
    public ResponseContent view(Request request) {
        FileResponseContent content = new FileResponseContent(new File("web/views/live.html"));
        content.manipulate().variable("host", request.getHeader("Host"));
        content.manipulate().variable("master", LedHandler.getInstance().getMaster());
        content.manipulate().variable("mute_status", LedHandler.getInstance().isMute() ? "danger" : "secondary");
        content.manipulate().variable("mute_icon", LedHandler.getInstance().isMute() ? "power-off" : "lightbulb");

        Iterable<Scene> scenes = Scene.FILE_SYSTEM.getEntries().stream().filter(Scene::isVisible).collect(Collectors.toList());
        content.manipulate().patternListName("form_scene", scenes);
        content.manipulate().patternListName("scene", scenes);

        content.manipulate().pattern(PatternCommand.create("devices").createSecondaries(device -> {
            PatternCommand colorCommand = device.getTwo().createChild("color");
            if (device.getOne().supportsRGB()) {
                colorCommand.addCostom(
                        new Pair<>("red", device.getOne().getValue(ChannelType.COLOR_RED).getValue()),
                        new Pair<>("green", device.getOne().getValue(ChannelType.COLOR_GREEN).getValue()),
                        new Pair<>("blue", device.getOne().getValue(ChannelType.COLOR_BLUE).getValue()),
                        new Pair<>("device", device.getOne().displayName())
                );
            }
            device.getTwo().createChild("control").createSecondaries(channel -> {
                ChannelValue value = device.getOne().getValue(channel.getOne());
                channel.getTwo().addCostom(new Pair<>("channel", channel.getOne().displayName()),
                        new Pair<>("value", value.getValue()),
                        new Pair<>("save", value.isSave() ? "info" : "warning"),
                        new Pair<>("device", device.getOne().displayName()));
            }, device.getOne().getChannels().stream().filter(type -> !type.isRgbChannel()).collect(Collectors.toList()));
        }, Controllable.FILE_SYSTEM.getEntries().stream().filter(Controllable::isVisible).collect(Collectors.toList())));
        return content;
    }

    @Deprecated
    @Mapping("liveaction/setvalue")
    public void setValue(Request request, @RequiredGet("device") String deviceName, @RequiredGet("channel") String channel, @RequiredGet("value") short value) {
        Controllable device = Controllable.FILE_SYSTEM.getEntry(deviceName);
        ChannelHandlerContext ctx = request.getDataFactory().getData(NettyRequest.CTX_KEY);
        ChannelType type = ChannelType.fromDisplayName(channel);

        device.setChannel(ctx, type, value);
    }

    @Mapping("liveaction/updatePrio")
    public void updatePrio(Request request) {
        request.getGet().forEach((device, o) -> {
            String value = o.iterator().next();
            Controllable controllable = Controllable.FILE_SYSTEM.getEntry(device);
            controllable.setPriority(Integer.valueOf(value));
            Controllable.FILE_SYSTEM.putEntry(device, controllable);
        });
    }

    @Deprecated
    @Mapping("liveaction/setrgb")
    public void setRGB(Request request, @RequiredGet("device") String deviceName, @RequiredGet("r") short r, @RequiredGet("g") short g, @RequiredGet("b") short b) {
        Controllable device = Controllable.FILE_SYSTEM.getEntry(deviceName);
        ChannelHandlerContext ctx = request.getDataFactory().getData(NettyRequest.CTX_KEY);

        device.setChannel(ctx, ChannelType.COLOR_RED, r);
        device.setChannel(ctx, ChannelType.COLOR_GREEN, g);
        device.setChannel(ctx, ChannelType.COLOR_BLUE, b);
    }

    @Mapping("liveaction/setmaster")
    public void setMaster(@RequiredGet("value") short value) {
        LedHandler.getInstance().setMaster(value);
    }

    @Mapping("liveaction/togglemute")
    public void toggleMute(Response response) {
        LedHandler.getInstance().toogleMute();
        response.redirect("/live", false);
    }

}
