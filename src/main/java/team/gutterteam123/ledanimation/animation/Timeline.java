package team.gutterteam123.ledanimation.animation;

import lombok.Getter;
import team.gutterteam123.ledanimation.animation.keyframes.KeyFrame;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Timeline {

    private String name;
    private List<KeyFrame> keyFrames = new ArrayList<>();

}
