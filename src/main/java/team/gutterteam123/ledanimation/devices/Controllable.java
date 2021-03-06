package team.gutterteam123.ledanimation.devices;

import io.github.splotycode.mosaik.annotations.HandleAsField;
import io.github.splotycode.mosaik.domparsing.annotation.DomEntry;
import io.github.splotycode.mosaik.domparsing.annotation.FileSystem;
import io.github.splotycode.mosaik.domparsing.annotation.parsing.SerialisedEntryParser;
import io.github.splotycode.mosaik.runtime.LinkBase;
import io.github.splotycode.mosaik.runtime.Links;
import io.netty.channel.ChannelHandlerContext;

import java.io.Serializable;
import java.util.Collection;

@DomEntry("controllable")
public interface Controllable extends Serializable, Comparable<Controllable> {

    FileSystem<Controllable> FILE_SYSTEM = LinkBase.getInstance().getLink(Links.PARSING_FILEPROVIDER).provide("controllables", new SerialisedEntryParser());

    void setChannel(ChannelHandlerContext ctx, ChannelType channel, short value);

    Collection<ChannelType> getChannels();

    default boolean supportsOperation(ChannelType operation) {
        return getChannels().contains(operation);
    }

    default boolean supportsRGB() {
        return supportsOperation(ChannelType.COLOR_RED) &&
               supportsOperation(ChannelType.COLOR_GREEN) &&
               supportsOperation(ChannelType.COLOR_BLUE);
    }

    @HandleAsField(name = "name")
    String displayName();

    @HandleAsField(name = "type")
    default String typeName() {
        return getClass().getSimpleName();
    }

    @HandleAsField(name = "priority")
    int priority();

    void setPriority(int priority);

    boolean isVisible();

    void setVisible(boolean visible);

    ChannelValue getValue(ChannelType type);

    @Override
    default int compareTo(Controllable controllable) {
        int type = typeName().compareTo(controllable.typeName());
        if (type == 0) {
            type = displayName().compareTo(controllable.displayName());
        }
        return type;
    }
}
