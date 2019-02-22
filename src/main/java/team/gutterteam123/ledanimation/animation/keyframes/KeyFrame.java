package team.gutterteam123.ledanimation.animation.keyframes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import team.gutterteam123.ledanimation.animation.ExecutionContext;

@Getter
@EqualsAndHashCode
public abstract class KeyFrame {

    private static final long serialVersionUID = 1L;

    protected int id;
    protected short start, end;

    public abstract void executeAction(ExecutionContext context);

    public abstract void step(ExecutionContext context);

}
