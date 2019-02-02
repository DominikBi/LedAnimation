package team.gutterteam123.ledanimation.devices;

import io.github.splotycode.mosaik.domparsing.annotation.DomEntry;
import io.github.splotycode.mosaik.domparsing.annotation.FileSystem;
import io.github.splotycode.mosaik.domparsing.annotation.parsing.ReflectiveParsingEntry;
import io.github.splotycode.mosaik.domparsing.annotation.parsing.SerialisedEntryParser;
import io.github.splotycode.mosaik.runtime.LinkBase;
import io.github.splotycode.mosaik.runtime.Links;
import io.github.splotycode.mosaik.webapi.response.content.manipulate.HandleAsField;

import java.io.Serializable;

@DomEntry("controllable")
public interface Controllable extends Serializable {

    FileSystem<Controllable> FILE_SYSTEM = LinkBase.getInstance().getLink(Links.PARSING_FILEPROVIDER).provide("controllables", new SerialisedEntryParser());

    void setChannel(ChannelType channel, short value);

    ChannelType getChannels();

    @HandleAsField(name = "name")
    String displayName();

    @HandleAsField(name = "type")
    default String typeName() {
        return getClass().getSimpleName();
    }

    boolean isVisible();

    void setVisible(boolean visible);

}
