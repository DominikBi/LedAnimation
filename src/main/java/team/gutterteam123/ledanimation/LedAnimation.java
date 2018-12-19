package team.gutterteam123.ledanimation;

import me.david.davidlib.application.Application;
import me.david.davidlib.startup.BootContext;
import me.david.webapi.WebApplicationType;
import me.david.webapi.server.netty.NettyWebServer;

public class LedAnimation extends Application implements WebApplicationType {
    @Override
    public void start(BootContext bootContext) throws Exception {
        setWebServer(new NettyWebServer(this));
        listen(5555);
    }

    @Override
    public String getName() {
        return "Led Animation";
    }
}
