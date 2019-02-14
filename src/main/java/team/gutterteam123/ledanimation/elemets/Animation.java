package team.gutterteam123.ledanimation.elemets;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
public class Animation {
    short id;
    String name;
    ArrayList<Long> actions;
}
