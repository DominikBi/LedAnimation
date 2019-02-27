package team.gutterteam123.ledanimation.server;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.ChannelMatchers;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.QueryStringEncoder;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.Getter;
import team.gutterteam123.ledanimation.devices.ChannelType;
import team.gutterteam123.ledanimation.devices.ChannelValue;
import team.gutterteam123.ledanimation.devices.Controllable;

@ChannelHandler.Sharable
public class WebSocketHandler extends SimpleChannelInboundHandler<WebSocketFrame> {

    @Getter private static WebSocketHandler instance = new WebSocketHandler();

    private final ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame frame) throws Exception {
        if (frame instanceof TextWebSocketFrame) {
            String text = ((TextWebSocketFrame) frame).text();
            if (text.equals("register")) {
                System.out.println("Registered " + ctx.channel().remoteAddress().toString());
                channels.add(ctx.channel());
            } else {
                if (text.startsWith("?")) {
                    QueryStringDecoder encoder = new QueryStringDecoder(text);
                    Controllable device = Controllable.FILE_SYSTEM.getEntry(encoder.parameters().get("device").get(0));
                    ChannelType type = ChannelType.fromDisplayName(encoder.parameters().get("channel").get(0));

                    device.setChannel(ctx, type, Short.valueOf(encoder.parameters().get("value").get(0)));
                } else {
                    String[] split = text.split(":");
                    Controllable device = Controllable.FILE_SYSTEM.getEntry(split[0]);
                    device.setChannel(ctx, ChannelType.COLOR_RED, Short.valueOf(split[1]));
                    device.setChannel(ctx, ChannelType.COLOR_GREEN, Short.valueOf(split[2]));
                    device.setChannel(ctx, ChannelType.COLOR_BLUE, Short.valueOf(split[3]));
                    updateValue(ctx, device);
                }
            }
        } else {
            throw new UnsupportedOperationException("Unsupported frame type: " + frame.getClass().getName());
        }
    }

    public void updateValue(ChannelHandlerContext ctx, Controllable device, ChannelType channel) {
        ChannelValue value = device.getValue(channel);
        channels.writeAndFlush(new TextWebSocketFrame(device.displayName() + ":" + channel.displayName() + ":" + value.isSave() + ":" + value.getValue()),
                ctx == null ? ChannelMatchers.all() : ChannelMatchers.isNot(ctx.channel()));
    }

    public void updateValue(ChannelHandlerContext ctx, Controllable device) {
        channels.writeAndFlush(new TextWebSocketFrame("rgb:" + device.displayName() + ":" +
                                                      device.getValue(ChannelType.COLOR_RED).getValue() + ":" +
                                                      device.getValue(ChannelType.COLOR_GREEN).getValue() + ":" +
                                                      device.getValue(ChannelType.COLOR_BLUE).getValue()),
                ctx == null ? ChannelMatchers.all() : ChannelMatchers.isNot(ctx.channel()));
    }

}
