package team.gutterteam123.ledanimation.animation.keyframes;

import io.github.splotycode.mosaik.util.datafactory.DataKey;
import team.gutterteam123.ledanimation.animation.ExecutionContext;
import team.gutterteam123.ledanimation.devices.ChannelType;
import team.gutterteam123.ledanimation.devices.Controllable;

public class SetValueKeyFrame extends KeyFrame {

    private static final DataKey<Controllable> DEVICE = new DataKey<>("device");

    private short value;
    private String deviceName;
    private ChannelType channel;

    @Override
    public void executeAction(ExecutionContext context) {
        context.putData(DEVICE, Controllable.FILE_SYSTEM.getEntry(deviceName));
    }

    @Override
    public void step(ExecutionContext context) {
        Controllable device = context.getData(DEVICE);
        short stepSize = (short) ((value - device.getValue(channel).getValue()) / (end - start));
        device.setChannel(channel, (short) (stepSize * context.position()));
    }
}
