package team.gutterteam123.ledanimation;

import io.github.splotycode.mosaik.runtime.LinkBase;
import io.github.splotycode.mosaik.runtime.application.Application;
import io.github.splotycode.mosaik.runtime.startup.BootContext;
import io.github.splotycode.mosaik.util.Timer;
import io.github.splotycode.mosaik.valuetransformer.TransformerManager;
import io.github.splotycode.mosaik.valuetransformer.ValueTransformer;
import io.github.splotycode.mosaik.webapi.WebApplicationType;
import io.github.splotycode.mosaik.webapi.config.WebConfig;
import io.github.splotycode.mosaik.webapi.handler.handlers.SinglePageHandler;
import io.github.splotycode.mosaik.webapi.handler.handlers.StaticFileSystemHandler;
import io.github.splotycode.mosaik.webapi.server.AbstractWebServer;
import io.github.splotycode.mosaik.webapi.server.netty.NettyWebServer;
import lombok.Getter;
import ola.OlaClient;
import team.gutterteam123.ledanimation.devices.LedHandler;
import team.gutterteam123.ledanimation.handlers.RoutingHandler;

import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class LedAnimation extends Application implements WebApplicationType {

    public static LedAnimation getInstance() {
        return LinkBase.getApplicationManager().getApplicationByClass(LedAnimation.class);
    }

    @Getter private LedHandler ledHandler;
    @Getter private RoutingHandler routingHandler = new RoutingHandler();

    @Override
    public void start(BootContext bootContext) throws Exception {
        LinkBase.getInstance().getLink(TransformerManager.LINK).registerPackage("team.gutterteam123.ledanimation.transformer");
        ledHandler = new LedHandler();

        configureWebServer();
        listen(5555);
    }

    private void configureWebServer() {
        setWebServer(new NettyWebServer(this));
        putConfig(WebConfig.NETTY_THREADS, 1);
        routingHandler.setUp();
    }

    @Override
    public String getName() {
        return "Led Animation";
    }
}
