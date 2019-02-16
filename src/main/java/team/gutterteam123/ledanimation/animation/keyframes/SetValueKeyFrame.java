package team.gutterteam123.ledanimation.animation.keyframes;

import team.gutterteam123.ledanimation.devices.ChannelType;
import team.gutterteam123.ledanimation.devices.Controllable;

public class SetValueKeyFrame extends StepableKeyFrame {

    private short value;
    private Controllable device;
    private ChannelType channel;
    private short startValue;

    @Override
    void step(int current) {

    }

    @Override
    void executeAction() {
        startValue = device.getValue(channel).getValue();
    }
}
