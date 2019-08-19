package team.gutterteam123.ledanimation.handlers;

import io.github.splotycode.mosaik.util.StringUtil;
import io.github.splotycode.mosaik.util.io.PathUtil;
import io.github.splotycode.mosaik.webapi.handler.HttpHandler;
import io.github.splotycode.mosaik.webapi.handler.handlers.RedirectHandler;
import io.github.splotycode.mosaik.webapi.handler.handlers.SinglePageHandler;
import io.github.splotycode.mosaik.webapi.handler.handlers.StaticFileSystemHandler;
import io.github.splotycode.mosaik.webapi.request.HandleRequestException;
import io.github.splotycode.mosaik.webapi.request.Request;
import io.github.splotycode.mosaik.webapi.response.content.file.CachedFileResponseContent;
import io.github.splotycode.mosaik.webapi.response.content.file.CachedStaticFileContent;
import io.github.splotycode.mosaik.webapi.response.content.manipulate.ManipulateableContent;
import io.github.splotycode.mosaik.webapi.session.Session;
import team.gutterteam123.ledanimation.LedAnimation;
import team.gutterteam123.ledanimation.user.LedSession;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RoutingHandler {

    private void register(HttpHandler handler) {
        LedAnimation.getInstance().getHttpRegister().register(handler);
    }

    public void setUp() {
        List<String> views = new ArrayList<>();

        for (File file : new File("web/views/").listFiles()) {
            views.add(PathUtil.getFileNameWithoutEx(file));
        }

        register(new StaticFileSystemHandler(new File("web/static"), "static"));
        register(RedirectHandler.createSimple(true, "/", "/device"));
        register(new HttpHandler() {

            @Override
            public boolean valid(Request request) throws HandleRequestException {
                return views.contains(request.getSimplifiedPath()) &&
                        request.hasPermission("");
            }

            @Override
            public boolean handle(Request request) throws HandleRequestException {
                ManipulateableContent content = new CachedFileResponseContent("web/base.html");
                content.manipulate().variable("user", ((LedSession) request.getSession()).getAccount().getName());
                request.getResponse().setContent(content);
                return false;
            }

        });
    }

}
