# androidWebsocket

A very simple bare-minimum WebSocket client for Android.



## Usage

Here's the entire API:

* connect

``` java 
List<BasicNameValuePair> extraHeaders = Arrays.asList(
        new BasicNameValuePair("Cookie", "session=abcd")
);
WebSocketClient client = new WebSocketClient(URI.create("ws://82.157.123.54:9010/ajaxchattest"), new Listener() {
    @Override
    public void onConnect() {
        Logs.d(TAG, "Connected!");
    }

    @Override
    public void onMessage(String message) {
        Logs.d(TAG, String.format("Got string message! %s", message));
    }

    @Override
    public void onMessage(byte[] data) {
        Logs.d(TAG, String.format("Got binary message! %s", new String(data)));
    }

    @Override
    public void onDisconnect(int code, String reason) {
        Logs.d(TAG, String.format("Disconnected! Code: %d Reason: %s", code, reason));
    }

    @Override
    public void onError(Exception error) {
        Logs.e(TAG, "Error!", error);
    }
}, extraHeaders);

 if (!client.isRunning()) {
    Logs.i(TAG, "will connect");
    client.connect();
}

```

* send message

``` java
 if (client != null) {
    client.send("hello!");
    client.send(new byte[]{(byte) 0xDE, (byte) 0xAD, (byte) 0xBE, (byte) 0xEF});
} 
```

* disconnect

``` java
if (client != null) {
    client.disconnect();
}
```


## thx

* [faye project](https://github.com/faye/faye-websocket-node)
* [Eric Butler](https://twitter.com/codebutler) 
* [SoloPi](https://github.com/alipay/SoloPi)



