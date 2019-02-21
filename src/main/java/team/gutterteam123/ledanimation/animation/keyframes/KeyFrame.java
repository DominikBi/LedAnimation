package team.gutterteam123.ledanimation.animation.keyframes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import team.gutterteam123.ledanimation.animation.ExecutionContext;

@Getter
@EqualsAndHashCode
public abstract class KeyFrame {

    protected int id;
    protected short start, end;

    public abstract void executeAction(ExecutionContext context);

    public abstract void step(ExecutionContext context);

}
