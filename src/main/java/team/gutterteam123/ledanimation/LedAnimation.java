package team.gutterteam123.ledanimation;

import io.github.splotycode.mosaik.runtime.LinkBase;
import io.github.splotycode.mosaik.runtime.application.Application;
import io.github.splotycode.mosaik.runtime.startup.BootContext;
import io.github.splotycode.mosaik.valuetransformer.TransformerManager;
import io.github.splotycode.mosaik.valuetransformer.ValueTransformer;
import io.github.splotycode.mosaik.webapi.WebApplicationType;
import io.github.splotycode.mosaik.webapi.server.netty.NettyWebServer;
import lombok.Getter;
import ola.OlaClient;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class LedAnimation extends Application implements WebApplicationType {

    private final short[] dmxChannels = new short[511];
    private OlaClient olaClient;

    public static LedAnimation getInstance() {
        return LinkBase.getApplicationManager().getApplicationByClass(LedAnimation.class);
    }

    public void setChannelSilent(int channel, short value) {
        synchronized (dmxChannels) {
            dmxChannels[channel] = value;
        }
    }

    public void setChannel(int channel, final short value) {
        final int readlchannel = channel - 1;
        setChannelSilent(readlchannel, value);
        getLogger().info("setting channel " + readlchannel + " to " + value);
        olaClient.sendDmx(1, dmxChannels);
    }

    @Override
    public void start(BootContext bootContext) throws Exception {
        LinkBase.getInstance().getLink(TransformerManager.LINK).registerPackage("team.gutterteam123.ledanimation.transformer");
        olaClient = new OlaClient();
        setWebServer(new NettyWebServer(this));
        listen(5555);
    }

    @Override
    public String getName() {
        return "Led Animation";
    }
}
