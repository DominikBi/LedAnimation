package team.gutterteam123.ledanimation.devices;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

public class DeviceGroup implements Controllable {

    @Getter private Collection<Device> devices = new ArrayList<>();
    private String name;
    @Getter
    @Setter
    private boolean visible;

    public DeviceGroup(String name) {
        this.name = name;
    }

    @Override
    public void setChannel(ChannelType channel, short value) {

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
