package team.gutterteam123.ledanimation.handlers;

import io.github.splotycode.mosaik.webapi.handler.anotation.check.Mapping;
import team.gutterteam123.ledanimation.devices.Controllable;

import java.util.ConcurrentModificationException;

public class AnimationHandler {


    @Mapping(value = "/EditAnimation")
    public void createAnimation(@RequiredGet (value = "name") String name){
        //Controllable folder = Controllable.FILE_SYSTEM



    }
    @Mapping(value = "/animation/delete")
    public void deleteAnimation(@RequiredGet(value = "name") String name){



    }
}
