package team.gutterteam123.ledanimation.transformer;

import io.github.splotycode.mosaik.util.ValueTransformer;
import io.github.splotycode.mosaik.util.datafactory.DataFactory;
import io.github.splotycode.mosaik.valuetransformer.TransformException;
import team.gutterteam123.ledanimation.devices.Controllable;

public class StringToControlableTransformer extends ValueTransformer<String, Controllable> {

    @Override
    public Controllable transform(String s, DataFactory data) throws TransformException {
        return Controllable.FILE_SYSTEM.getEntry(s);
    }
}
