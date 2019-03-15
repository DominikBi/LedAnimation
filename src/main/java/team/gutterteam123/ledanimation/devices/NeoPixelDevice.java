package team.gutterteam123.ledanimation.devices;

import com.google.common.collect.Lists;
import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import lombok.Setter;
import team.gutterteam123.ledanimation.server.WebSocketHandler;

import java.util.*;

public class NeoPixelDevice implements Controllable {

    @Getter @Setter private boolean visible;
    @Setter private int priority;

    private Map<ChannelType, Short> values = new HashMap<>();

    private String displayName;

    public NeoPixelDevice(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public void setChannel(ChannelHandlerContext ctx, ChannelType channel, short value) {
        values.put(channel, value);
        WebSocketHandler.getInstance().updateValue(ctx, this, channel);
    }

    @Override
    public Collection<ChannelType> getChannels() {
        return Arrays.asList(ChannelType.BRIGHTNESS, ChannelType.COLOR_RED, ChannelType.COLOR_GREEN, ChannelType.COLOR_BLUE);
    }

    @Override
    public boolean supportsRGB() {
        return true;
    }

    @Override
    public String displayName() {
        return displayName;
    }

    @Override
    public int priority() {
        return priority;
    }

    @Override
    public ChannelValue getValue(ChannelType type) {
        return new ChannelValue(true, values.get(type));
    }
}
