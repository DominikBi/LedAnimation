package team.gutterteam123.ledanimation.devices;

import lombok.Getter;
import lombok.Setter;
import team.gutterteam123.ledanimation.LedAnimation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Device implements Controllable {

    private static final long serialVersionUID = 1L;

    private Map<ChannelType, Integer> channels = new HashMap<>();
    private String name;
    @Getter @Setter
    private boolean visible;

    public Map<ChannelType, Integer> getChannelMap() {
        return channels;
    }

    public Device(String name) {
        this.name = name;
    }

    @Override
    public void setChannel(ChannelType channel, short value) {
        LedAnimation.getInstance().setChannel(channels.get(channel), value);
    }

    @Override
    public Collection<ChannelType> getChannels() {
        return channels.keySet();
    }

    @Override
    public String displayName() {
        return name;
    }


}
