package team.gutterteam123.ledanimation.devices;

import io.github.splotycode.mosaik.util.Timer;
import io.github.splotycode.mosaik.util.logger.Logger;
import lombok.Getter;
import ola.OlaClient;

public class LedHandler {

    @Getter private static LedHandler instance;

    private Logger logger = Logger.getInstance(getClass());

    @Getter private final DMXChannel[] dmxChannels = new DMXChannel[511];
    private OlaClient olaClient;
    @Getter private short master;

    public LedHandler() throws Exception {
        instance = this;
        olaClient = new OlaClient();
    }

    public void setChannelSilent(int channel, short value, boolean masterable) {
        channel--;
        dmxChannels[channel] = new DMXChannel(value, masterable);
    }

    public void setChannel(int channel, short value, boolean masterable) {
        channel--;
        dmxChannels[channel] = new DMXChannel(value, masterable);
        logger.info("setting channel " + channel + " to " + value);
        Timer timer = new Timer();
        timer.start();
        refresh();
        logger.info("done in " + timer.getDelay());
    }

    public void refresh() {
        olaClient.sendDmx(1, getOutputDMX());
    }

    public void setMaster(short master) {
        this.master = master;
        refresh();
    }

    public short getRawValue(int channel) {
        DMXChannel dmx = dmxChannels[channel];
        return dmx == null ? 0 : dmx.getRawValue();
    }

    public short[] getOutputDMX() {
        short[] out = new short[511];
        int i = 0;
        for (DMXChannel channel : dmxChannels) {
            if (channel != null) {
                out[i] = channel.isMasterable() ? (short) (channel.getRawValue() * (master / 100f)) : channel.getRawValue();
            }
            i++;
        }
        return out;
    }

}
