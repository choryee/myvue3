package com.example.myvue3.websocket;


import org.eclipse.jetty.websocket.server.JettyWebSocketServlet;
import org.eclipse.jetty.websocket.server.JettyWebSocketServletFactory;

@SuppressWarnings("serial")
public class WSServlet extends JettyWebSocketServlet {
    @Override
    public void configure(JettyWebSocketServletFactory factory) {
        factory.register(WSSocket.class);
    }
}
