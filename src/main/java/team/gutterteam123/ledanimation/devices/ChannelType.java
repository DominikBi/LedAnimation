package team.gutterteam123.ledanimation.devices;

import io.github.splotycode.mosaik.util.EnumUtil;
import io.github.splotycode.mosaik.webapi.response.content.manipulate.HandleAsField;
import lombok.Getter;

public enum ChannelType {

    COLOR_RED(true), COLOR_BLUE(true), COLOR_GREEN(true), BRIGHTNESS, PAN, TILT, STROBE, GLOBO, GLOBO_SPEED;

    ChannelType() {
        this(false);
    }

    ChannelType(boolean rgbChannel) {
        this.rgbChannel = rgbChannel;
    }

    @Getter private boolean rgbChannel;

    @HandleAsField(name = "dname")
    public String displayName() {
        return EnumUtil.toDisplayName(this).replace("-", " ");
    }

    public static ChannelType fromDisplayName(String displayName) {
        return valueOf(displayName.replace(" ", "_").toUpperCase());
    }


}
