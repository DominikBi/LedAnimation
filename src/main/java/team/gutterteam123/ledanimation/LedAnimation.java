package team.gutterteam123.ledanimation;

import me.david.davidlib.application.Application;
import me.david.davidlib.startup.BootContext;
import me.david.webapi.WebApplicationType;

public class LedAnimation extends Application implements WebApplicationType {
    @Override
    public void start(BootContext bootContext) throws Exception {

    }

    @Override
    public String getName() {
        return "Led Animation";
    }
}
