package team.gutterteam123.ledanimation.handlers;

import io.github.splotycode.mosaik.webapi.handler.anotation.check.Handler;
import io.github.splotycode.mosaik.webapi.handler.anotation.check.Mapping;
import io.github.splotycode.mosaik.webapi.response.content.ResponseContent;
import io.github.splotycode.mosaik.webapi.response.content.file.CachedFileResponseContent;
import team.gutterteam123.ledanimation.devices.Controllable;

import java.io.File;

@Handler
public class Views {

    @Mapping("/device")
    public ResponseContent device() {
        CachedFileResponseContent content = new CachedFileResponseContent(new File("web/devices.html"));
        for (Controllable  cont : Controllable.FILE_SYSTEM.getEntries()) {
            System.out.println(cont);
        }
        content.manipulate().pattern(Controllable.FILE_SYSTEM.getEntries());
        return content;
    }

}
