package com.example.reactive_web.service;

import com.example.reactive_web.model.User;
import com.example.reactive_web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @Auther: changzhaoliang
 * @Date: 2018/11/26 17:58
 * @Description:
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Mono<User> findByUsername(String username) {
        return userRepository.findByAdmin(username);
    }
}
