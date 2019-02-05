package team.gutterteam123.ledanimation.transformer;

import io.github.splotycode.mosaik.valuetransformer.TransformException;
import io.github.splotycode.mosaik.valuetransformer.ValueTransformer;
import team.gutterteam123.ledanimation.devices.Controllable;

public class StringToControlableTransformer extends ValueTransformer<String, Controllable> {

    @Override
    public Controllable transform(String s) throws TransformException {
        return Controllable.FILE_SYSTEM.getEntry(s);
    }
}
