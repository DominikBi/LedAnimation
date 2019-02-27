package team.gutterteam123.ledanimation.server;

import io.github.splotycode.mosaik.webapi.server.netty.NettyChannelInitializer;
import io.github.splotycode.mosaik.webapi.server.netty.NettyWebServer;
import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;

public class ChannelInitializer extends NettyChannelInitializer {

    public ChannelInitializer(NettyWebServer webServer) {
        super(webServer);
    }

    @Override
    protected void initChannel(Channel channel) {
        super.initChannel(channel);
        ChannelPipeline pipeline = channel.pipeline();

        pipeline.remove("handler");
        pipeline.addLast(new WebSocketServerCompressionHandler());
        pipeline.addLast(new WebSocketServerProtocolHandler("/websocket", null, true));
        pipeline.addLast("handler", webServer.getHandler());
        pipeline.addLast(new WebSocketHandler());
    }
}
