package com.walker.nio.netty_demo.client.handler;

import com.walker.nio.netty_demo.dto.UnixTime;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by walker on 2017/2/18.
 */
public class UnixTimeDecoder extends ByteToMessageDecoder { // (1)
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) { // (2)
        if (in.readableBytes() < 4) {
            return; // (3)
        }

        out.add(new UnixTime(in.readUnsignedInt())); // (4)

    }
}
