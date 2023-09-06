package com.lenovo.mutimodeshow;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lenovo.mutimodeshow.bean.PassengerInfo;

import java.util.Arrays;
import java.util.List;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class WsListener extends WebSocketListener {
    private String TAG = "websocket";
    public static int count = 1;
    private Gson gson = new Gson();
    private List<String> foodList;
    private Context context;
    private PassengerInfoListioner passengerInfoListioner;

    public void setPassengerInfoListioner(PassengerInfoListioner passengerInfoListioner){
        this.passengerInfoListioner=passengerInfoListioner;
    }
    public WsListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClosed(WebSocket webSocket, int code, String reason) {
        super.onClosed(webSocket, code, reason);
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        super.onClosing(webSocket, code, reason);
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        super.onFailure(webSocket, t, response);
        Log.e(TAG, "connect failed is =========:" + t.getLocalizedMessage());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        super.onMessage(webSocket, text);
        Log.e(TAG, "客户端收到消息:" + text);
        PassengerInfo passengerInfo = gson.fromJson(text, PassengerInfo.class);
        this.passengerInfoListioner.onPassengerInfo(passengerInfo);
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        super.onMessage(webSocket, bytes);
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        super.onOpen(webSocket, response);
        Log.e(TAG, "连接成功！");
    }

    interface PassengerInfoListioner{
        void onPassengerInfo(PassengerInfo passengerInfo);
    }
}

