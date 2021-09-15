package me.hhhaiai.ws.client;
public interface Listener {
    public void onConnect();

    public void onMessage(String message);

    public void onMessage(byte[] data);

    public void onDisconnect(int code, String reason);

    public void onError(Exception error);
}