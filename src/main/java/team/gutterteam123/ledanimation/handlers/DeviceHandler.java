package team.gutterteam123.ledanimation.handlers;

import me.david.webapi.handler.anotation.check.Mapping;
import me.david.webapi.handler.anotation.handle.RequiredGet;
import me.david.webapi.response.Response;
import me.david.webapi.response.content.ResponseContent;
import team.gutterteam123.ledanimation.LedAnimation;
import team.gutterteam123.ledanimation.elemets.Device;

@Mapping(value = "devices/**")
public class DeviceHandler  {
        public void create(@RequiredGet( value = "name") String name, Response response){
            LedAnimation.getInstance().getDevices().putIfAbsent(name, new Device(name));
            response.redirect("/devices/", false);
        }
}

