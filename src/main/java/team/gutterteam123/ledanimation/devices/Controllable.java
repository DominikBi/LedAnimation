package team.gutterteam123.ledanimation.devices;

import io.github.splotycode.mosaik.domparsing.annotation.DomEntry;
import io.github.splotycode.mosaik.domparsing.annotation.FileSystem;
import io.github.splotycode.mosaik.domparsing.annotation.parsing.ReflectiveParsingEntry;
import io.github.splotycode.mosaik.runtime.LinkBase;
import io.github.splotycode.mosaik.runtime.Links;

@DomEntry("controllable")
public interface Controllable {

    FileSystem<Controllable> FILE_SYSTEM = LinkBase.getInstance().getLink(Links.PARSING_FILEPROVIDER).provide("controlables", new ReflectiveParsingEntry());

    void setChannel(ChannelType channel, short value);

    ChannelType getChannels();

    String displayName();

}
