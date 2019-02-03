package team.gutterteam123.ledanimation.devices;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

public class DeviceGroup implements Controllable {

    @Getter private transient Collection<Device> devices = new ArrayList<>();
    private Collection<String> rawDevices = new ArrayList<>();

    public DeviceGroup() {
        for (String device : rawDevices) {
            devices.add((Device) Controllable.FILE_SYSTEM.getEntry(device));
        }
    }

    private String name;
    @Getter @Setter private boolean visible;

    public DeviceGroup(String name) {
        this.name = name;
    }

    @Override
    public void setChannel(ChannelType channel, short value) {

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
    public ChannelType getChannels() {
        return null;
    }

    @Override
    public String displayName() {
        return name;
    }
}
