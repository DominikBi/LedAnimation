package team.gutterteam123.ledanimation.devices;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DMXChannel {

    private short rawValue;
    private boolean masterable;

}
