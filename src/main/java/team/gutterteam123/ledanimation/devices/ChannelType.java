package team.gutterteam123.ledanimation.devices;

import io.github.splotycode.mosaik.annotations.HandleAsField;
import io.github.splotycode.mosaik.util.EnumUtil;
import lombok.Getter;

public enum ChannelType {

    COLOR_RED(true), COLOR_BLUE(true), COLOR_GREEN(true), BRIGHTNESS, PAN, TILT, STROBE, GLOBO, GLOBO_SPEED, ZOOM;

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
