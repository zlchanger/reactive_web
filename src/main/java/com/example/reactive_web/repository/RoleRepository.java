package com.example.reactive_web.repository;

import com.example.reactive_web.model.Role;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @Auther: changzhaoliang
 * @Date: 2018/11/27 11:01
 * @Description:
 */
public interface RoleRepository extends ReactiveMongoRepository<Role,String>{
}
