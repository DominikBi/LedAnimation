package team.gutterteam123.ledanimation.devices;

import io.github.splotycode.mosaik.util.logger.Logger;
import io.github.splotycode.mosaik.webapi.request.HandleRequestException;
import lombok.Getter;
import ola.OlaClient;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LedHandler {

    @Getter private static LedHandler instance;
    private static Throwable loadError;

    static {
        try {
            instance = new LedHandler();
        } catch (Throwable e) {
            loadError = e;
        }
    }

    private Logger logger = Logger.getInstance(getClass());

    private final DMXChannel[] dmxChannels = new DMXChannel[511];
    private final OlaClient olaClient;
    private Lock lock = new ReentrantLock();
    @Getter private short master;
    @Getter private boolean mute;

    public LedHandler() throws Exception {
        instance = this;
        olaClient = new OlaClient();
    }

    public void setChannelSilent(int channel, short value, boolean masterable) {
        channel--;
        lock.lock();
        try {
            dmxChannels[channel] = new DMXChannel(value, masterable);
        } finally {
            lock.unlock();
        }
    }

    public void setChannel(int channel, short value, boolean masterable) {
        channel--;
        lock.lock();
        try {
            dmxChannels[channel] = new DMXChannel(value, masterable);
            logger.info("setting channel " + channel + " to " + value);
            //TODO stats? Timer timer = new Timer();
            //timer.start();
            refresh0();
        } finally {
            lock.unlock();
        }
    }

    public void toogleMute() {
        lock.lock();
        try {
            mute = !mute;
            refresh0();
        } finally {
            lock.unlock();
        }
    }

    public void refresh() {
        lock.lock();
        try {
            refresh0();
        } finally {
            lock.unlock();
        }
    }

    private void refresh0() {
        if (loadError != null) {
            throw new HandleRequestException("Controller connection was not established", loadError);
        }
        olaClient.sendDmx(1, getOutputDMX());
    }

    public void setMaster(short master) {
        lock.lock();
        try {
            this.master = master;
            refresh0();
        } finally {
            lock.unlock();
        }
    }

    public void setMute(boolean mute) {
        lock.lock();
        try {
            this.mute = mute;
            refresh0();
        } finally {
            lock.unlock();
        }
    }

    public short getRawValue(int channel) {
        channel--;
        lock.lock();
        short val;
        try {
            DMXChannel dmx = dmxChannels[channel];
            val = dmx == null ? 0 : dmx.getRawValue();
        } finally {
            lock.unlock();
        }
        return val;
    }

    private short[] getOutputDMX() {
        short[] out = new short[511];
        int i = 0;
        for (DMXChannel channel : dmxChannels) {
            if (channel != null) {
                out[i] = channel.isMasterable() ?
                        (short) (channel.getRawValue() * ((mute ? 0f : master) / 100f)) :
                        channel.getRawValue();
            }
            i++;
        }
        return out;
    }

}
