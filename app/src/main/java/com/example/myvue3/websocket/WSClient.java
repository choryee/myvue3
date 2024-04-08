package com.example.myvue3.websocket;


import java.net.URI;
import java.util.concurrent.Future;
import java.util.concurrent.*;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.client.WebSocketClient;
//import org.eclipse.jetty.websocket.*;


public class WSClient {
    public static void main(String[] args) {
        URI uri = URI.create("ws://localhost:8082/events/");

        WebSocketClient client = new WebSocketClient();
        try {
            try {
                client.start();
                WSSocket socket = new WSSocket();
                Future<Session> future = client.connect(socket, uri);
                Session session = future.get();
                session.getRemote().sendString("Hello, 제발 좀....io!");
                session.close();
            } finally {
                client.stop();
            }
        } catch ( Throwable t ) {
            t.printStackTrace(System.err);
        }
    }
}
