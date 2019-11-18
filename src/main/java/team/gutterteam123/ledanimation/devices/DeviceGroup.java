package team.gutterteam123.ledanimation.devices;

import io.github.splotycode.mosaik.domparsing.annotation.EntryListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.Getter;
import lombok.Setter;
import team.gutterteam123.ledanimation.LedAnimation;
import team.gutterteam123.ledanimation.server.WebSocketHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DeviceGroup implements Controllable, EntryListener {

    private static final long serialVersionUID = 1L;

    @Getter private transient Collection<Device> devices;
    @Getter private Collection<String> rawDevices = new ArrayList<>();

    private String name;
    @Getter @Setter private boolean visible;

    @Setter
    private int priority;

    public DeviceGroup() {
        devices = new ArrayList<>();
    }

    public DeviceGroup(String name) {
        this();
        this.name = name;
    }

    @Override
    public void setChannel(ChannelHandlerContext ctx, ChannelType channel, short value) {
        boolean wasSave = isSave(channel);
        for (Device child : getDevices0()) {
            if (child.supportsOperation(channel)) {
                child.setChannel(null, channel, value);
            }
        }
        WebSocketHandler.getInstance().updateValue(ctx, this, channel);
        /* If the Group was unsafe it is save now */
        if (!wasSave) {
            WebSocketHandler.getInstance().publish(ctx, displayName() + ":" + channel.displayName() + ":" + true);
        }
    }

    private boolean isSave(ChannelType type) {
        short current = -1;
        for (Device child : getDevices0()) {
            short val = child.getValue(type).getValue();
            if (current == -1) {
                current = val;
            } else if (val != current) {
                return false;
            }
        }
        return true;
    }

    protected Collection<Device> getDevices0() {
        return devices;
    }

    public void registerDevice(Device device) {
        devices.add(device);
        rawDevices.add(device.displayName());
    }

    public void unregisterDevice(Device device) {
        devices.remove(device);
        rawDevices.remove(device.displayName());
    }

    @Override
    public Collection<ChannelType> getChannels() {
        Set<ChannelType> channels = new HashSet<>();
        for (Device child : getDevices0()) {
            channels.addAll(child.getChannels());
        }
        return channels;
    }

    @Override
    public String displayName() {
        return name;
    }

    @Override
    public ChannelValue getValue(ChannelType type) {
        short current = -1;
        boolean save = true;

        for (Device child : getDevices0()) {
            short val = child.getValue(type).getValue();
            if (current == -1) {
                current = val;
            } else if (val != current) {
                save = false;
                break;
            }
        }

        if (!save) {
            int sum = 0;
            for (Device child : getDevices0()) {
                sum += child.getValue(type).getValue();
            }
            current = (short) (sum / devices.size());
        }
        return new ChannelValue(save, current);
    }

    @Override public void preSerialisation() {}
    @Override public void postSerialisation() {}

    @Override
    public void postDeserialization() {
        devices = new ArrayList<>();
        for (String device : rawDevices) {
            devices.add((Device) Controllable.FILE_SYSTEM.getEntry(device));
        }
    }

    @Override
    public int priority() {
        return priority;
    }
}
