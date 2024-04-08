package com.example.myvue3.websocket;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.WebSocketHandler;
import jakarta.servlet.Servlet;
@Service
@CrossOrigin("ws://localhost/8083")
public class WebSocketServer {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    private final Servlet wsSocketHandler;
    private final WebSocketConfig webSocketConfig;

    private Server server;

    @Autowired
    public WebSocketServer(Servlet wsSocketHandler, WebSocketConfig webSocketConfig) {
        this.wsSocketHandler = wsSocketHandler;
        this.webSocketConfig = webSocketConfig;
    }

    public void start() {
        try {
            // Server 생성
            server = new Server();

            // ServerConnector 생성 및 포트 설정
            ServerConnector connector = new ServerConnector(server);
            connector.setPort(8083);
            server.addConnector(connector);

            // Setup the basic application "context" for this application at "/"
            // This is also known as the handler tree (in jetty speak)
            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/");
            server.setHandler(context);

            // Add a websocket to a specific path spec
            ServletHolder holderEvents = new ServletHolder("ws-events", wsSocketHandler);
            context.addServlet(holderEvents, "/events/*");

            server.start();
            server.dump(System.err);
            server.join();
        } catch (Throwable t) {
            logger.error("WebSocket Server Start Error", t);
            t.printStackTrace(System.err);
        }
    }
}