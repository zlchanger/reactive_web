//package com.example.reactive_web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
//import org.springframework.http.server.reactive.HttpHandler;
//import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.RouterFunctions;
//import reactor.ipc.netty.http.server.HttpServer;
///**
// * @Auther: changzhaoliang
// * @Date: 2018/11/19 16:35
// * @Description: 通过定义让其可以运行在任何容器
// */
//@Configuration
//@EnableAutoConfiguration
//@EnableReactiveMongoRepositories(basePackages = "com.example.reactive_web.service")
//public class HttpServerConfig {
//    private final Environment environment;
//
//    @Autowired
//    public HttpServerConfig(Environment environment) {
//        this.environment = environment;
//    }
//
//    @Bean
//    public HttpServer httpServer(RouterFunction<?> routerFunction) {
//        HttpHandler httpHandler = RouterFunctions.toHttpHandler(routerFunction);
//        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
//        HttpServer server = HttpServer.create("localhost", Integer.valueOf(environment.getProperty("server.port")));
//        server.newHandler(adapter);
//        return server;
//    }
//}
