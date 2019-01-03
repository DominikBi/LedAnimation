package team.gutterteam123.ledanimation.elemets;

import team.gutterteam123.ledanimation.LedAnimation;

import java.util.HashMap;
import java.util.Map;

public class Device implements Controllable {

    private Map<ChannelType, Integer> channels = new HashMap<>();

    @Override
    public void setChannel(ChannelType channel, float value) {
        LedAnimation.getInstance().setChannel(channels.get(channel), value);
    }

    @Override
    public String displayName() {
        return null;
    }
}
