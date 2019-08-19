package team.gutterteam123.ledanimation.devices;


import java.util.ArrayList;
import java.util.Collection;

public class AllGroup extends DeviceGroup {

    private static final long serialVersionUID = 1L;

    @Override
    public String displayName() {
        return "All";
    }

    @Override
    protected Collection<Device> getDevices0() {
        Collection<Device> devices = new ArrayList<>();
        for (Controllable controllable : FILE_SYSTEM.getEntries()) {
            if (controllable instanceof Device) {
                devices.add((Device) controllable);
            }
        }
        return devices;
    }

    @Override public void postSerialisation() {}

    @Override public void registerDevice(Device device) {}
    @Override public void unregisterDevice(Device device) {}
}
