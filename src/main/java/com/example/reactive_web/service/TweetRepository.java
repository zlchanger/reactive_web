package com.example.reactive_web.service;

import com.example.reactive_web.model.Tweet;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @Auther: changzhaoliang
 * @Date: 2018/11/19 14:07
 * @Description:
 */
@Repository
public interface TweetRepository extends ReactiveMongoRepository<Tweet,String> {

    @Query("{ id: { $exists: true }}")
    Flux<Tweet> retrieveAllTweetsPaged(final Pageable page);

}
