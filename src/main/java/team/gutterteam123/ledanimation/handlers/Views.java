package team.gutterteam123.ledanimation.handlers;

import io.github.splotycode.mosaik.util.Pair;
import io.github.splotycode.mosaik.webapi.handler.anotation.check.Handler;
import io.github.splotycode.mosaik.webapi.handler.anotation.check.Mapping;
import io.github.splotycode.mosaik.webapi.response.Response;
import io.github.splotycode.mosaik.webapi.response.content.ResponseContent;
import io.github.splotycode.mosaik.webapi.response.content.file.FileResponseContent;
import team.gutterteam123.ledanimation.devices.Controllable;

import java.io.File;
import java.util.stream.Collectors;

@Handler
public class Views {

    @Mapping("/device")
    public ResponseContent device() {
        FileResponseContent content = new FileResponseContent(new File("web/devices.html"));
        for (Controllable controllable : Controllable.FILE_SYSTEM.getEntries()) {
            System.out.println(controllable.displayName() + " " + controllable.isVisible());
            content.manipulate().patternCostomWithObj("devices", controllable, new Pair<>("visible-status", controllable.isVisible() ? "primary" : "secondary"));
        }
        return content;
    }

    @Mapping("/login")
    public ResponseContent login() {
        return new FileResponseContent(new File("web/static/login.html"));
    }

    @Mapping("/")
    public void home(Response response) {
        response.redirect("/device", true);
    }

    @Mapping("/animation")
    public ResponseContent AnimationOverview(){
        FileResponseContent content = new FileResponseContent(new File("web/AnimationOverview.html"));
        content.manipulate().pattern("animation", Controllable.FILE_SYSTEM.getEntries());
        return content;
    }

    @Mapping("/live")
    public ResponseContent controlLive(){
        FileResponseContent content = new FileResponseContent(new File("web/controlLive.html"));
        content.manipulate().pattern("devices", Controllable.FILE_SYSTEM.getEntries());
        return content;
    }

    @Mapping("/liveStart")
    public ResponseContent liveStart(){
        FileResponseContent content = new FileResponseContent(new File("web/Live.html"));
        content.manipulate().pattern("live", Controllable.FILE_SYSTEM.getEntries());
        return content;
    }
}
