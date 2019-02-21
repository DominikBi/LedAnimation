package team.gutterteam123.ledanimation.handlers;

import io.github.splotycode.mosaik.annotations.Disabled;
import io.github.splotycode.mosaik.util.Pair;
import io.github.splotycode.mosaik.webapi.handler.anotation.check.Handler;
import io.github.splotycode.mosaik.webapi.handler.anotation.check.Mapping;
import io.github.splotycode.mosaik.webapi.response.Response;
import io.github.splotycode.mosaik.webapi.response.content.ResponseContent;
import io.github.splotycode.mosaik.webapi.response.content.file.FileResponseContent;
import io.github.splotycode.mosaik.webapi.response.content.manipulate.pattern.PatternCommand;
import team.gutterteam123.ledanimation.LedAnimation;
import team.gutterteam123.ledanimation.devices.*;

import java.io.File;
import java.util.stream.Collectors;

@Disabled
@Deprecated
public class Views {


    //@Mapping("/device")
    public ResponseContent device() {
        FileResponseContent content = new FileResponseContent(new File("web/devices.html"));
        for (Controllable controllable : Controllable.FILE_SYSTEM.getEntries()) {
            content.manipulate().patternCostomWithObj("devices", controllable, new Pair<>("visible-status", controllable.isVisible() ? "primary" : "secondary"));
        }
        return content;
    }

    //@Mapping("/scene")
    public ResponseContent scene() {
        FileResponseContent content = new FileResponseContent(new File("web/scene.html"));
        for (Scene controllable : Scene.FILE_SYSTEM.getEntries()) {
            content.manipulate().patternCostomWithObj("scenes", controllable);
        }
        return content;
    }

    //@Mapping("/login")
    public ResponseContent login() {
        return new FileResponseContent(new File("web/static/login.html"));
    }

    @Mapping("/")
    public void home(Response response) {
        response.redirect("/device", true);
    }

    //@Mapping("/animation")
    public ResponseContent AnimationOverview(){
        FileResponseContent content = new FileResponseContent(new File("web/AnimationOverview.html"));
        content.manipulate().pattern("animation", Controllable.FILE_SYSTEM.getEntries());
        return content;
    }

    //@Mapping("/live")
    public ResponseContent live(){
        FileResponseContent content = new FileResponseContent(new File("web/live.html"));
        content.manipulate().variable("master", LedAnimation.getInstance().getLedHandler().getMaster());
        content.manipulate().pattern(PatternCommand.create("devices").createSecondaries(device -> {
            PatternCommand colorCommand = device.getTwo().createChild("color");
            if (device.getOne().supportsRGB()) {
                colorCommand.addCostom(
                        new Pair<>("red", device.getOne().getValue(ChannelType.COLOR_RED)),
                        new Pair<>("green", device.getOne().getValue(ChannelType.COLOR_GREEN)),
                        new Pair<>("blue", device.getOne().getValue(ChannelType.COLOR_BLUE)),
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

}
