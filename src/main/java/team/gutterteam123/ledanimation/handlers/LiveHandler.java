package team.gutterteam123.ledanimation.handlers;

import io.github.splotycode.mosaik.webapi.handler.anotation.check.Mapping;
import io.github.splotycode.mosaik.webapi.handler.anotation.handle.RequiredGet;
import team.gutterteam123.ledanimation.LedAnimation;
import team.gutterteam123.ledanimation.devices.ChannelType;
import team.gutterteam123.ledanimation.devices.Controllable;

public class LiveHandler {

    @Mapping("liveaction/setvalue")
    public void setValue(@RequiredGet("device") String deviceName, @RequiredGet("channel") String channel, @RequiredGet("value") short value) {
        Controllable device = Controllable.FILE_SYSTEM.getEntry(deviceName);
        device.setChannel(ChannelType.fromDisplayName(channel), value);
    }

    @Mapping("liveaction/setmaster")
    public void setValue(@RequiredGet("value") short value) {
        LedAnimation.getInstance().getLedHandler().setMaster(value);
    }



}
