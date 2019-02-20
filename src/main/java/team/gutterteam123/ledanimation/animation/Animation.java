package team.gutterteam123.ledanimation.animation;

import io.github.splotycode.mosaik.domparsing.annotation.FileSystem;
import io.github.splotycode.mosaik.domparsing.annotation.parsing.SerialisedEntryParser;
import io.github.splotycode.mosaik.runtime.LinkBase;
import io.github.splotycode.mosaik.runtime.Links;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import team.gutterteam123.ledanimation.animation.keyframes.KeyFrame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter @Setter
@EqualsAndHashCode
public class Animation implements Serializable {

    public static final FileSystem<Animation> FILE_SYSTEM = LinkBase.getInstance().getLink(Links.PARSING_FILEPROVIDER).provide("animation", new SerialisedEntryParser());

    private int fps;
    private int end;

    private String name;
    private Map<String, KeyFrame> keyFrames = new HashMap<>();

    public Animation(String name) {
        this.name = name;
    }
}
