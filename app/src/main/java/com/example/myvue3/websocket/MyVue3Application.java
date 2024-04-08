package com.example.myvue3.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyVue3Application {

    public static void main(String[] args) {
        // Spring Boot 애플리케이션을 실행하고 컨텍스트를 가져옴
        ConfigurableApplicationContext context = SpringApplication.run(MyVue3Application.class, args);

        // WebSocketServer 빈을 가져와서 WebSocket 서버를 시작
//        WebSocketServer webSocketServer = context.getBean(WebSocketServer.class);
//        webSocketServer.start();
    }
}
