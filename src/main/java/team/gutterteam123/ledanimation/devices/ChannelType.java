package team.gutterteam123.ledanimation.devices;

import io.github.splotycode.mosaik.util.EnumUtil;
import io.github.splotycode.mosaik.webapi.response.content.manipulate.HandleAsField;

public enum ChannelType {

    COLOR_RED, COLOR_BLUE, COLOR_GREEN, BRIGHTNESS;

    @HandleAsField(name = "dname")
    public String displayName() {
        return EnumUtil.toDisplayName(this).replace("-", " ");
    }

    public static ChannelType fromDisplayName(String displayName) {
        return valueOf(displayName.replace(" ", "_").toUpperCase());
    }


}
