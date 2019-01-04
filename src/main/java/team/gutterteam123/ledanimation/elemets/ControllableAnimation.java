package team.gutterteam123.ledanimation.elemets;

public interface ControllableAnimation {
    void createAnimation(short AnimationId, String name);

    short getAnimationId();

    String displayAnimationName();
}
