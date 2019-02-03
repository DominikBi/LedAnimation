package team.gutterteam123.ledanimation.handlers;

import io.github.splotycode.mosaik.webapi.handler.anotation.check.Mapping;
import io.github.splotycode.mosaik.webapi.handler.anotation.handle.RequiredGet;
import io.github.splotycode.mosaik.webapi.response.Response;
import team.gutterteam123.ledanimation.devices.Controllable;
import team.gutterteam123.ledanimation.devices.Device;
import team.gutterteam123.ledanimation.devices.DeviceGroup;

public class DeviceHandler  {

    @Mapping(value = "devices/create")
    public void create(@RequiredGet(value = "name") String name, @RequiredGet(value = "type") int type, Response response){
        Controllable.FILE_SYSTEM.putEntry(name, type == 2 ? new DeviceGroup(name) : new Device(name));
        response.redirect("/device", false);
    }

    @Mapping(value = "devices/delete")
    public void delete(@RequiredGet(value = "name") String name, Response response){
        Controllable.FILE_SYSTEM.deleteEntry(name);
        response.redirect("/device", false);
    }
    @Mapping(value = "devices/visible")
    public void setVisible(@RequiredGet(value = "name") String name, Response response){
        Controllable controllable = Controllable.FILE_SYSTEM.getEntry(name);
        controllable.setVisible(!controllable.isVisible());
        response.redirect("/device", false);
    }


    @AllArgsConstructor
    public static class SelectableDevice {
        private String name;
        private String selected;
    }

    @Mapping(value = "devices/settings")
    public ResponseContent settings(@RequiredGet(value = "name") String name){
        Controllable controllable = Controllable.FILE_SYSTEM.getEntry(name);
        if (controllable instanceof DeviceGroup) {
            DeviceGroup group = (DeviceGroup) controllable;

            List<SelectableDevice> selectables = new ArrayList<>();

            FileResponseContent content = new FileResponseContent("web/settings_group.html");
            for (Device device : group.getDevices()) {
                selectables.add(new SelectableDevice(device.displayName(), "selected"));
            }
            for (Controllable controllables : Controllable.FILE_SYSTEM.getEntries()) {
                if (controllables instanceof Device && !group.getDevices().contains(controllables)) {
                    selectables.add(new SelectableDevice(controllables.displayName(), ""));
                }
            }
            content.manipulate().patternListName("devices", selectables);
            content.manipulate().variable("name", name);
            return content;
        } else {
            Device device = (Device) controllable;
            FileResponseContent content = new FileResponseContent("web/settings_device.html");
            for (Map.Entry<ChannelType, Integer> entry : device.getChannelMap().entrySet()) {
                content.manipulate().patternCostomName("used_channels",
                        new Pair<>("type", entry.getKey().displayName()),
                        new Pair<>("channel", entry.getValue()),
                        new Pair<>("device", device.displayName()));
            }
            content.manipulate().patternArrayName("channels", ChannelType.values());
            content.manipulate().variable("device", name);
            return content;
        }
    }

    @Mapping("devices/addchannel")
    public void addChannel(@RequiredGet("device") String deviceName, @RequiredGet("type") String type, @RequiredGet("channel") int channel, Response response) {
        Device device = (Device) Controllable.FILE_SYSTEM.getEntry(deviceName);
        device.getChannelMap().put(ChannelType.fromDisplayName(type), channel);
        Controllable.FILE_SYSTEM.putEntry(deviceName, device);
        response.redirect("/devices/settings/?name=" + deviceName, false);
    }

    @Mapping("devices/deletechannel")
    public void deleteChannel(@RequiredGet("device") String deviceName, @RequiredGet("type") String type, Response response) {
        Device device = (Device) Controllable.FILE_SYSTEM.getEntry(deviceName);
        device.getChannelMap().remove(ChannelType.fromDisplayName(type));
        Controllable.FILE_SYSTEM.putEntry(deviceName, device);
        response.redirect("/devices/settings/?name=" + deviceName, false);
    }

    @Mapping("devices/update")
    public void update(@RequiredGet("devices") String devices, @RequiredGet("name") String name, Response response) {
        DeviceGroup group = (DeviceGroup) Controllable.FILE_SYSTEM.getEntry(name);
        group.getDevices().clear();
        response.redirect("/device", false);
    }

}

