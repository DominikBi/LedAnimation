package team.gutterteam123.ledanimation.elemets;

import java.util.ArrayList;
import java.util.Collection;

public class DeviceGroup implements Controllable {

    private Collection<Device> devices = new ArrayList<>();

    @Override
    public void setChannel(ChannelType channel, short value) {

    }

    @Override
    public ChannelType getChannels() {
        return null;
    }

    @Override
    public String displayName() {
        return null;
    }
}
