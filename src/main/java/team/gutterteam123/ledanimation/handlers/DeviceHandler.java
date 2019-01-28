package team.gutterteam123.ledanimation.handlers;

import io.github.splotycode.mosaik.webapi.handler.anotation.check.Mapping;
import io.github.splotycode.mosaik.webapi.handler.anotation.handle.RequiredGet;
import io.github.splotycode.mosaik.webapi.response.Response;
import team.gutterteam123.ledanimation.devices.Controllable;
import team.gutterteam123.ledanimation.devices.Device;

@Mapping(value = "devices/**")
public class DeviceHandler  {

    @Mapping(value = "devices/create")
    public void create(@RequiredGet(value = "name") String name, Response response){
        Controllable.FILE_SYSTEM.putEntry(name, new Device(name));
        response.redirect("/device", false);
    }

    @Mapping(value = "devices/delete")
    public void delete(@RequiredGet(value = "name") String name, Response response){
        Controllable.FILE_SYSTEM.deleteEntry(name);
        response.redirect("/device", false);
    }

}

