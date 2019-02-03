package team.gutterteam123.ledanimation.devices;

import lombok.Getter;
import lombok.Setter;
import team.gutterteam123.ledanimation.LedAnimation;

import java.util.HashMap;
import java.util.Map;

public class Device implements Controllable {

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
    public ChannelType getChannels() {
        return null;
    }

    @Override
    public String displayName() {
        return name;
    }


}
