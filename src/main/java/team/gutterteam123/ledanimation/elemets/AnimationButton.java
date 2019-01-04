package team.gutterteam123.ledanimation.elemets;

public class AnimationButton implements ControllableAnimation {
public String name;
    @Override
    public void createAnimation(short AnimationId, String name) {

    }

    @Override
    public short getAnimationId() {
        return 0;
    }

    @Override
    public String displayAnimationName() {
        return name;
    }
}
