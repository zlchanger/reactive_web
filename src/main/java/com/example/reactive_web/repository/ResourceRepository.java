package com.example.reactive_web.repository;

import com.example.reactive_web.model.Resource;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @Auther: changzhaoliang
 * @Date: 2018/11/27 11:52
 * @Description:
 */
public interface ResourceRepository extends ReactiveMongoRepository<Resource, String> {
}
