package team.gutterteam123.ledanimation.handlers;

import io.github.splotycode.mosaik.webapi.handler.anotation.check.Mapping;
import io.github.splotycode.mosaik.webapi.handler.anotation.handle.RequiredGet;
import io.github.splotycode.mosaik.webapi.response.Response;
import io.github.splotycode.mosaik.webapi.response.content.ResponseContent;
import io.github.splotycode.mosaik.webapi.response.content.file.FileResponseContent;
import io.github.splotycode.mosaik.webapi.response.content.manipulate.ManipulateableContent;
import io.github.splotycode.mosaik.webapi.response.content.string.StaticStringContent;
import team.gutterteam123.ledanimation.animation.Animation;
import team.gutterteam123.ledanimation.animation.AnimationExecutor;

import java.io.File;

public class AnimationHandler {

    @Mapping(value = "views/animation")
    public ResponseContent view() {
        FileResponseContent content = new FileResponseContent(new File("web/views/animation.html"));
        content.manipulate().patternList(Animation.FILE_SYSTEM.getEntries());
        return content;
    }


    @Mapping(value = "animations/create")
    public void create(Response response, @RequiredGet(value = "name") String name) {
        Animation.FILE_SYSTEM.putEntry(name, new Animation(name));
        response.redirect("/animations/edit?name=" + name, false);
    }

    @Mapping(value = "animations/play")
    public void play(Response response, @RequiredGet(value = "name") String name){
        AnimationExecutor.getInstance().execute(Animation.FILE_SYSTEM.getEntry(name));
        response.redirect("/animation" + name, false);
    }

    //TODO
    @Mapping(value = "animations/edit")
    public ResponseContent edit(@RequiredGet(value = "name") String name) {
        ManipulateableContent content = new FileResponseContent("web/editanimation.html");
        content.manipulate().variable("name", name);
        return content;
    }

    //TODO
    @Mapping(value = "animations/save")
    public void save(Response response, @RequiredGet(value = "name") String name) {
        response.redirect("/animation" + name, false);
    }

    @Mapping(value = "animations/delete")
    public void delete(Response response, @RequiredGet(value = "name") String name){
        Animation.FILE_SYSTEM.deleteEntry(name);
        response.redirect("/animation" + name, false);
    }
}
