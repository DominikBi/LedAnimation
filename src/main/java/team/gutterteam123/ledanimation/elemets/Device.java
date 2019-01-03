package team.gutterteam123.ledanimation.elemets;

import team.gutterteam123.ledanimation.LedAnimation;

import java.util.HashMap;
import java.util.Map;

public class Device implements Controllable {

    private Map<ChannelType, Integer> channels = new HashMap<>();
    private String name;

    public Device(String name) {
        this.name = name;
    }

    @Override
    public void setChannel(ChannelType channel, short value) {
        LedAnimation.getInstance().setChannel(channels.get(channel), value);
    }

    @Override
    public String displayName() {
        return name;
    }
}
