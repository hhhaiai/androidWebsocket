package me.hhhaiai.ws.client;
import java.io.IOException;

public  class ProtocolError extends IOException {
    public ProtocolError(String detailMessage) {
        super(detailMessage);
    }
}