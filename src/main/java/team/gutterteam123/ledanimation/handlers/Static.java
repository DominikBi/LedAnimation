package team.gutterteam123.ledanimation.handlers;

import me.david.webapi.handler.anotation.check.Handler;
import me.david.webapi.handler.anotation.check.Mapping;
import me.david.webapi.request.Request;
import me.david.webapi.response.content.ResponseContent;
import me.david.webapi.response.content.file.CachedStaticFileContent;

@Handler
public class Static {

    @Mapping("static/**")
    public ResponseContent staticSite(Request request) {
        String path = request.getPath().substring(1);
        return new CachedStaticFileContent("web/static" + path.substring(path.indexOf('/')));
    }

}
