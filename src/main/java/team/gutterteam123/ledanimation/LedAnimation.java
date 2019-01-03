package team.gutterteam123.ledanimation;

import lombok.Getter;
import me.david.davidlib.application.Application;
import me.david.davidlib.link.LinkBase;
import me.david.davidlib.startup.BootContext;
import me.david.webapi.WebApplicationType;
import me.david.webapi.server.netty.NettyWebServer;
import ola.OlaClient;

@Getter
public class LedAnimation extends Application implements WebApplicationType {

    private short[] dmxChannels = new short[512];
    private OlaClient olaClient;


    public static LedAnimation getInstance() {
        return LinkBase.getApplicationManager().getApplicationByClass(LedAnimation.class);
    }

    public void setChannelSilent(int channel, short value) {
        dmxChannels[channel] = value;
    }

    public void setChannel(int channel, short value) {
        setChannelSilent(channel, value);
        olaClient.sendDmx(1, dmxChannels);
    }

    @Override
    public void start(BootContext bootContext) throws Exception {
        olaClient = new OlaClient();
        setWebServer(new NettyWebServer(this));
        listen(5555);
    }

    @Override
    public String getName() {
        return "Led Animation";
    }
}
