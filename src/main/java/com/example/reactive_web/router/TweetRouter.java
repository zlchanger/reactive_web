package com.example.reactive_web.router;

import com.example.reactive_web.handler.TweetHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

/**
 * @Auther: changzhaoliang
 * @Date: 2018/11/19 15:42
 * @Description:
 */
@Configuration
public class TweetRouter {
    private final TweetHandler handler;

    @Autowired
    public TweetRouter(TweetHandler handler) {
        this.handler = handler;
    }


    @Bean
    public RouterFunction<?> routerFunction() {
        return route(GET("/api/tweet/{id}").and(accept(MediaType.APPLICATION_JSON_UTF8)), handler::findOne)
                .and(route(GET("/api/tweet").and(accept(MediaType.APPLICATION_JSON_UTF8)), handler::findAll)
                        .and(route(POST("/api/tweet").and(accept(MediaType.APPLICATION_JSON_UTF8)), handler::create)));
    }
}
