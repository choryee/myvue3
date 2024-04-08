package com.example.myvue3.websocket;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;

@WebSocket
public class WsSocketHandler extends WebSocketAdapter {
    @OnWebSocketConnect
    public void onWebSocketConnect(Session sess) {
        System.out.println("- Socket Connected: " + sess);
    }

    @OnWebSocketMessage
    public void onWebSocketText(String message) {
        System.out.println("- Received Text message: " + message);
    }

    @OnWebSocketClose
    public void onWebSocketClose(int statusCode, String reason) {
        System.out.println("- Socket Closed: [" + statusCode + "] " + reason);
    }

    @OnWebSocketError
    public void onWebSocketError(Throwable cause) {
        cause.printStackTrace(System.err);
    }
}
