package me.hhhaiai.ws.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public  class HappyDataInputStream extends DataInputStream {
    public HappyDataInputStream(InputStream in) {
        super(in);
    }

    public byte[] readBytes(int length) throws IOException {
        byte[] buffer = new byte[length];
        readFully(buffer);
        return buffer;
    }
}