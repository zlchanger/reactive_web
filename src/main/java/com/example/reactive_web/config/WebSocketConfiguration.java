package com.example.reactive_web.config;

import com.example.reactive_web.handler.EchoHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: changzhaoliang
 * @Date: 2018/11/14 17:13
 * @Description:
 * 运行应用之后，可以使用工具来测试该 WebSocket 服务。
 * 打开工具页面 https://www.websocket.org/echo.html，
 * 然后连接到 ws://localhost:8080/echo，可以发送消息并查看服务器端返回的结果。
 */
@Configuration
public class WebSocketConfiguration {

    //HandlerMapping 类型的 bean 把 EchoHandler 映射到路径 /echo。
    @Autowired
    @Bean
    public HandlerMapping webSocketMapping(final EchoHandler echoHandler) {
        final Map<String, WebSocketHandler> map = new HashMap<>(1);
        map.put("/echo", echoHandler);

        final SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setOrder(Ordered.HIGHEST_PRECEDENCE);
        mapping.setUrlMap(map);
        return mapping;
    }

    //负责把 WebSocketHandler 关联到 WebFlux 中
    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter();
    }
}
