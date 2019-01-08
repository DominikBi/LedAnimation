package team.gutterteam123.ledanimation.handlers;

import me.david.webapi.handler.anotation.check.Mapping;
import me.david.webapi.handler.anotation.handle.RequiredGet;
import me.david.webapi.response.Response;
import team.gutterteam123.ledanimation.LedAnimation;
import team.gutterteam123.ledanimation.elemets.Device;

@Mapping(value = "devices/**")
public class DeviceHandler  {

    @Mapping(value = "devices/create")
    public void create(@RequiredGet(value = "name") String name, Response response){
        LedAnimation.getInstance().getDevices().putIfAbsent(name, new Device(name));
    }
    @Mapping(value = "devices/delete")
    public void delete(@RequiredGet(value = "name") String name, Response response){
        try {
            LedAnimation.getInstance().getDevices().remove(name);
        } catch (Exception NameNotFound){
            //info-popup
        }
    }
    @Mapping(value = "devices/createAnimation")
    public void createAnimation(@RequiredGet(value = "AnimationName") String name, Response response){

    }

}

