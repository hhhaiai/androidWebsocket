package me.hhhaiai.ws.client.demo;


import android.content.Context;

import org.apache.http.message.BasicNameValuePair;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import me.hhhaiai.ws.utils.Logs;
import me.hhhaiai.ws.client.Listener;
import me.hhhaiai.ws.client.WebSocketClient;


/**
 * @Copyright © 2021 analsys Inc. All rights reserved.
 * @Description: websocket 测试方法
 * @Version: 1.0
 * @Create: 2021/09/258 11:14:34
 * @author: sanbo
 */
public class TestWs {
    private static final String TAG = "TestWs";
    private static Context mContext = null;
    private static List<BasicNameValuePair> extraHeaders = Arrays.asList(
            new BasicNameValuePair("Cookie", "session=abcd")
    );

    private static WebSocketClient client = null;

    public static void connect(Context ctx) {

        if (mContext == null && ctx != null) {
            mContext = ctx.getApplicationContext();
        }

        if (client == null) {
            Logs.d(TAG, "client is null, will new instance !");
            client = new WebSocketClient(URI.create("ws://82.157.123.54:9010/ajaxchattest"), new Listener() {
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
        } else {
            Logs.i(TAG, "client already has instance !");
        }

        if (!client.isRunning()) {
            Logs.i(TAG, "will connect");
            client.connect();
        } else {
            Logs.d(TAG, "already running");
        }

    }


    public static void sendMsg(Context ctx) {
        if (mContext == null && ctx != null) {
            mContext = ctx.getApplicationContext();
        }
        if (client != null) {
            client.send("hello!");
            client.send(new byte[]{(byte) 0xDE, (byte) 0xAD, (byte) 0xBE, (byte) 0xEF});
        } else {
            Logs.e(TAG, "send message. the client is null!");
        }

    }

    public static void disconnect(Context ctx) {
        if (mContext == null && ctx != null) {
            mContext = ctx.getApplicationContext();
        }
        if (client != null) {
            client.disconnect();
        } else {
            Logs.e(TAG, "disconnect. the client is null!");
        }
    }
}
