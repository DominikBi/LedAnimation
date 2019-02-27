package team.gutterteam123.ledanimation;

import io.github.splotycode.mosaik.runtime.LinkBase;
import io.github.splotycode.mosaik.runtime.application.Application;
import io.github.splotycode.mosaik.runtime.startup.BootContext;
import io.github.splotycode.mosaik.valuetransformer.TransformerManager;
import io.github.splotycode.mosaik.webapi.WebApplicationType;
import io.github.splotycode.mosaik.webapi.config.WebConfig;
import io.github.splotycode.mosaik.webapi.server.netty.NettyWebServer;
import lombok.Getter;
import team.gutterteam123.ledanimation.handlers.RoutingHandler;
import team.gutterteam123.ledanimation.server.ChannelInitializer;

@Getter
public class LedAnimation extends Application implements WebApplicationType {

    public static LedAnimation getInstance() {
        return LinkBase.getApplicationManager().getApplicationByClass(LedAnimation.class);
    }

    @Getter private RoutingHandler routingHandler = new RoutingHandler();

    @Override
    public void start(BootContext bootContext) throws Exception {
        LinkBase.getInstance().getLink(TransformerManager.LINK).registerPackage("team.gutterteam123.ledanimation.transformer");

        configureWebServer();
        listen(5555, false);
    }

    private void configureWebServer() {
        NettyWebServer webServer = new NettyWebServer(this);
        ChannelInitializer initializer = new ChannelInitializer(webServer);

        setWebServer(webServer);
        webServer.setChannelInitializer(initializer);

        putConfig(WebConfig.NETTY_THREADS, 1);
        //putConfig(WebConfig.IGNORE_NO_SSL_RECORD, true);
        //putConfig(WebConfig.FORCE_HTTPS, false);
        routingHandler.setUp();
    }

    @Override
    public String getName() {
        return "Led Animation";
    }
}
