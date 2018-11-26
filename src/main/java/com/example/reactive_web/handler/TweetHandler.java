package com.example.reactive_web.handler;

import com.example.reactive_web.model.Tweet;
import com.example.reactive_web.service.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @Auther: changzhaoliang
 * @Date: 2018/11/19 15:36
 * @Description:
 */
@Component
public class TweetHandler {

    private final TweetRepository tweetRepository;

    @Autowired
    public TweetHandler (TweetRepository tweetRepository){
        this.tweetRepository = tweetRepository;
    }

    public Mono<ServerResponse> findAll(ServerRequest request){
        return ServerResponse.ok().body(this.tweetRepository.findAll(),Tweet.class);
    }

    public Mono<ServerResponse> findOne(ServerRequest request){
        return ServerResponse.ok().body(this.tweetRepository.findById(request.pathVariable("id")), Tweet.class);
    }

    public Mono<ServerResponse> create(ServerRequest request){
        Mono<Tweet> tweetMono = request.bodyToMono(Tweet.class);
        return ServerResponse.ok().body(this.tweetRepository.insert(tweetMono), Tweet.class);
    }

}
