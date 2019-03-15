package team.gutterteam123.ledanimation.neopixel;

import io.github.splotycode.mosaik.argparser.Parameter;
import io.github.splotycode.mosaik.runtime.LinkBase;
import io.github.splotycode.mosaik.runtime.startup.StartupTask;
import io.github.splotycode.mosaik.runtime.startup.environment.StartUpEnvironmentChanger;
import team.gutterteam123.ledanimation.LedAnimation;

public class NeoPixelStartup implements StartupTask {

    @Parameter(name = "neo")
    private boolean neo;

    @Override
    public void execute(StartUpEnvironmentChanger ec) throws Exception {
        LinkBase.getBootContext().applyArgs(this);
        System.out.println(neo);
        if (neo) {
            ec.stopApplicationStart(LedAnimation.class);
        } else {
            ec.stopApplicationStart(NeoPixelApplication.class);
        }
    }

}
