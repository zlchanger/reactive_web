package com.example.reactive_web.repository;

import com.example.reactive_web.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * @Auther: changzhaoliang
 * @Date: 2018/11/26 18:14
 * @Description:
 */
public interface UserRepository extends ReactiveMongoRepository<User,String> {

    Mono<User> findByAdmin(String admin);
}
