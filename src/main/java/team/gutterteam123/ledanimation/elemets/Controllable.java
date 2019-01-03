package team.gutterteam123.ledanimation.elemets;

public interface Controllable {

    void setChannel(ChannelType channel, short value);

    ChannelType getChannels();

    String displayName();

}
