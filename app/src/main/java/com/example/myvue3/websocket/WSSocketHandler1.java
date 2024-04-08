package com.example.myvue3.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WSSocketHandler1 extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // WebSocket에서 메시지를 받아 처리하는 로직을 구현합니다.
        String payload = message.getPayload();
        // ...
    }
}
