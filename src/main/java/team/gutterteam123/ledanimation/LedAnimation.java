package team.gutterteam123.ledanimation;

import lombok.Getter;
import me.david.davidlib.runtimeapi.LinkBase;
import me.david.davidlib.runtimeapi.application.Application;
import me.david.davidlib.runtimeapi.startup.BootContext;
import me.david.webapi.WebApplicationType;
import me.david.webapi.server.netty.NettyWebServer;
import ola.OlaClient;
import team.gutterteam123.ledanimation.elemets.Controllable;

import java.util.HashMap;
import java.util.Map;

@Getter
public class LedAnimation extends Application implements WebApplicationType {

    private short[] dmxChannels = new short[512];
    private OlaClient olaClient;
    private Map<String, Controllable> devices = new HashMap<>();


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
