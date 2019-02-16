package team.gutterteam123.ledanimation.handlers;

import io.github.splotycode.mosaik.webapi.handler.anotation.check.Mapping;
import io.github.splotycode.mosaik.webapi.handler.anotation.handle.RequiredGet;
import io.github.splotycode.mosaik.webapi.response.Response;
import team.gutterteam123.ledanimation.devices.*;

import java.util.HashMap;
import java.util.Map;

public class SceneHandler {

    @Mapping(value = "scenes/delete")
    public void delete(@RequiredGet(value = "name") String name, Response response){
        Scene.FILE_SYSTEM.deleteEntry(name);
        response.redirect("/scene", false);
    }

    @Mapping(value = "scenes/play")
    public void play(@RequiredGet(value = "name") String name, Response response){
        Scene.FILE_SYSTEM.getEntry(name).load();
        response.redirect("/scene", false);
    }

    @Mapping(value = "scenes/create")
    public void create(@RequiredGet(value = "name") String name, Response response){
        Map<String, Map<ChannelType, Short>> values = new HashMap<>();
        for (Controllable controllable : Controllable.FILE_SYSTEM.getEntries()) {
            Map<ChannelType, Short> channels = new HashMap<>();
            for (ChannelType channel : controllable.getChannels()) {
                channels.put(channel, controllable.getValue(channel).getValue());
            }
            values.put(controllable.displayName(), channels);
        }
        Scene.FILE_SYSTEM.putEntry(name, new Scene(name, values));
        response.redirect("/scene", false);
    }

}
