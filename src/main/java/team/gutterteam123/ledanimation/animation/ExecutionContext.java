package team.gutterteam123.ledanimation.animation;

import io.github.splotycode.mosaik.util.datafactory.DataFactory;
import io.github.splotycode.mosaik.util.datafactory.DataKey;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;

@EqualsAndHashCode
public class ExecutionContext {

    @Getter private Animation animation;

    public ExecutionContext(Animation animation) {
        this.animation = animation;
    }

    private short currentFrame;
    private int currentKeyFrame;
    private HashMap<Integer, DataFactory> data = new HashMap<>();

    public <T> void putData(DataKey<T> dataKey, T value) {
        getFactory().putData(dataKey, value);
    }

    public DataFactory getFactory() {
        return data.computeIfAbsent(currentKeyFrame, num -> new DataFactory());
    }

    public <T> T getData(DataKey<T> dataKey) {
        return getFactory().getData(dataKey);
    }

    public void nextKeyFrame(int frameID) {
        currentKeyFrame = frameID;
    }

    public void next() {
        currentFrame++;
    }

    public short position() {
        return currentFrame;
    }

}
