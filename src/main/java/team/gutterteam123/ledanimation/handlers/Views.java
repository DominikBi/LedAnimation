package team.gutterteam123.ledanimation.handlers;

import io.github.splotycode.mosaik.webapi.handler.anotation.check.Handler;
import io.github.splotycode.mosaik.webapi.handler.anotation.check.Mapping;
import io.github.splotycode.mosaik.webapi.response.Response;
import io.github.splotycode.mosaik.webapi.response.content.ResponseContent;
import io.github.splotycode.mosaik.webapi.response.content.file.CachedFileResponseContent;
import io.github.splotycode.mosaik.webapi.response.content.file.FileResponseContent;
import team.gutterteam123.ledanimation.devices.Controllable;

import java.io.File;

@Handler
public class Views {

    @Mapping("/device")
    public ResponseContent device() {
        FileResponseContent content = new FileResponseContent(new File("web/devices.html"));
        content.manipulate().pattern("devices", Controllable.FILE_SYSTEM.getEntries());
        return content;
    }

    @Mapping("/")
    public void home(Response response) {
        response.redirect("/device", true);
    }

}
