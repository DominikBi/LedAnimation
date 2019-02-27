package team.gutterteam123.ledanimation.handlers;

import io.github.splotycode.mosaik.util.Pair;
import io.github.splotycode.mosaik.webapi.handler.anotation.check.Mapping;
import io.github.splotycode.mosaik.webapi.handler.anotation.handle.RequiredGet;
import io.github.splotycode.mosaik.webapi.response.Response;
import io.github.splotycode.mosaik.webapi.response.content.ResponseContent;
import io.github.splotycode.mosaik.webapi.response.content.file.FileResponseContent;
import lombok.AllArgsConstructor;
import team.gutterteam123.ledanimation.devices.ChannelType;
import team.gutterteam123.ledanimation.devices.Controllable;
import team.gutterteam123.ledanimation.devices.Device;
import team.gutterteam123.ledanimation.devices.DeviceGroup;

import java.io.File;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class DeviceHandler  {

    @Mapping(value = "views/device")
    public ResponseContent view() {
        FileResponseContent content = new FileResponseContent(new File("web/views/device.html"));
        for (Controllable controllable : Controllable.FILE_SYSTEM.getEntries()) {
            content.manipulate().patternCostomWithObj("devices", controllable,
                    new Pair<>("visible-status", controllable.isVisible() ? "primary" : "secondary"),
                    new Pair<>("eye", controllable.isVisible() ? "" : "-slash"));
        }
        return content;
    }

    @Mapping(value = "devices/create")
    public void create(@RequiredGet(value = "name") String name, @RequiredGet(value = "type") int type, Response response){
        Controllable.FILE_SYSTEM.putEntry(name, type == 2 ? new DeviceGroup(name) : new Device(name));
        response.redirect("/device", false);
    }

    @Mapping(value = "devices/delete")
    public void delete(@RequiredGet(value = "name") String name, Response response){
        /* Remove device in groups */
        for (Controllable controllable : Controllable.FILE_SYSTEM.getEntries()) {
            if (controllable instanceof DeviceGroup) {
                DeviceGroup group = (DeviceGroup) controllable;
                if (group.getRawDevices().contains(name)) {
                    group.unregisterDevice((Device) Controllable.FILE_SYSTEM.getEntry(name));
                    Controllable.FILE_SYSTEM.putEntry(group.displayName(), group);
                }
            }
        }

        Controllable.FILE_SYSTEM.deleteEntry(name);

        response.redirect("/device", false);
    }

    @Mapping(value = "devices/visible")
    public void setVisible(@RequiredGet(value = "name") String name, Response response){
        Controllable controllable = Controllable.FILE_SYSTEM.getEntry(name);
        controllable.setVisible(!controllable.isVisible());
        Controllable.FILE_SYSTEM.putEntry(name, controllable);
        response.redirect("/device", false);
    }

    @Mapping(value = "devices/settings")
    public ResponseContent settings(@RequiredGet(value = "name") Controllable controllable){
        String name = controllable.displayName();
        if (controllable instanceof DeviceGroup) {
            DeviceGroup group = (DeviceGroup) controllable;

            FileResponseContent content = new FileResponseContent("web/settings_group.html");

            for (Device child : group.getDevices()) {
                content.manipulate().patternCostomWithObj("linked", child, new Pair<>("device", group.displayName()));
            }

            List<Device> selectable = new ArrayList<>();
            for (Controllable cont : Controllable.FILE_SYSTEM.getEntries()) {
                if (cont instanceof Device && !group.getRawDevices().contains(cont.displayName())) {
                    selectable.add((Device) cont);
                }
            }
            content.manipulate().patternListName("devices", selectable);
            content.manipulate().variable("device", name);
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
    public void update(@RequiredGet("channel") String name, Response response) {
        DeviceGroup group = (DeviceGroup) Controllable.FILE_SYSTEM.getEntry(name);
        group.getDevices().clear();
        response.redirect("/device", false);
    }

    @Mapping("devices/addToGroup")
    public void addToGroup(@RequiredGet("device") String deviceName, @RequiredGet("add") Controllable add, Response response) {
        DeviceGroup device = (DeviceGroup) Controllable.FILE_SYSTEM.getEntry(deviceName);
        device.registerDevice((Device) add);
        Controllable.FILE_SYSTEM.putEntry(deviceName, device);
        response.redirect("/devices/settings/?name=" + deviceName, false);
    }

    @Mapping("devices/removeFromGroup")
    public void removeFromGroup(@RequiredGet("device") String deviceName, @RequiredGet("remove") Controllable remove, Response response) {
        DeviceGroup device = (DeviceGroup) Controllable.FILE_SYSTEM.getEntry(deviceName);
        device.unregisterDevice((Device) remove);
        Controllable.FILE_SYSTEM.putEntry(deviceName, device);
        response.redirect("/devices/settings/?name=" + deviceName, false);
    }

    @Mapping("devices/editchannel")
    public void editChannel(Response response, @RequiredGet("device") Controllable controllable, @RequiredGet("type") String type, @RequiredGet("channel") int channel) {
        Device device = (Device) controllable;
        ChannelType channelType = ChannelType.fromDisplayName(type);
        device.getChannelMap().put(channelType, channel);
        Controllable.FILE_SYSTEM.putEntry(device.displayName(), device);
        response.redirect("/devices/settings/?name=" + device.displayName(), false);
    }

}

