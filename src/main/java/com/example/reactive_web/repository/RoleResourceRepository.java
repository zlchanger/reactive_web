package com.example.reactive_web.repository;

import com.example.reactive_web.model.RoleResource;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @Auther: changzhaoliang
 * @Date: 2018/11/27 13:10
 * @Description:
 */
public interface RoleResourceRepository extends ReactiveMongoRepository<RoleResource, String> {
}
