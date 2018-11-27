package com.example.reactive_web.repository;

import com.example.reactive_web.model.UserRole;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @Auther: changzhaoliang
 * @Date: 2018/11/27 13:11
 * @Description:
 */
public interface UserRoleRepository extends ReactiveMongoRepository<UserRole, String> {
}
