package team.gutterteam123.ledanimation.handlers;

import io.github.splotycode.mosaik.util.StringUtil;
import io.github.splotycode.mosaik.util.io.PathUtil;
import io.github.splotycode.mosaik.webapi.handler.HttpHandler;
import io.github.splotycode.mosaik.webapi.handler.handlers.RedirectHandler;
import io.github.splotycode.mosaik.webapi.handler.handlers.SinglePageHandler;
import io.github.splotycode.mosaik.webapi.handler.handlers.StaticFileSystemHandler;
import io.github.splotycode.mosaik.webapi.response.content.manipulate.ManipulateableContent;
import team.gutterteam123.ledanimation.LedAnimation;

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
        register(new SinglePageHandler(new File("web/base.html"), "url") {
            @Override
            protected String toVarPath(String path) {
                return "/views/" + path;
            }

            @Override
            protected ManipulateableContent manipulate(ManipulateableContent content, String rawPath, String path) {
                content.manipulate().variable(rawPath, "active");
                content.manipulate().variable("site", StringUtil.camelCase(rawPath));
                for (String view : views) {
                    if (!view.equals(rawPath)) {
                        content.manipulate().variable(view, "");
                    }
                }
                return content;
            }
        });
    }

}
