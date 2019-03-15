package team.gutterteam123.ledanimation.neopixel;

import io.github.splotycode.mosaik.argparser.Parameter;
import io.github.splotycode.mosaik.runtime.application.Application;
import io.github.splotycode.mosaik.runtime.startup.BootContext;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.StandardCharsets;

public class NeoPixelApplication extends Application {

    @Parameter(name = "address", needed = true)
    private String address;

    @Override
    public void start(BootContext bootContext) throws Exception {
        bootContext.applyArgs(this);

        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel channel) throws Exception {
                    channel.pipeline().addLast(
                            new StringEncoder(StandardCharsets.UTF_8),
                            new LineBasedFrameDecoder(1024 * 2),
                            new StringDecoder(StandardCharsets.UTF_8)/*,
                            new EchoClientHandler()*/);
                }
            });
            bootstrap.connect(address, 8889).sync().channel().closeFuture().sync();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

    @Override
    public String getName() {
        return "Neo Pixel";
    }

}
