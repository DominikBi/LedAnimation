package team.gutterteam123.ledanimation.elemets;


public class AnimationButton implements ControllableAnimation{
public String name;
    @Override
    public void createAnimation(short AnimationId, String name) {
        Animation animation = new Animation();
        animation.name = name;
        animation.id = AnimationId;
    }


    @Override
    public short getAnimationId() { return 0; }

    @Override
    public String displayAnimationName() {
        return name;
    }
}
