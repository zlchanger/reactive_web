package com.example.reactive_web.controller;

import com.example.reactive_web.security.JWTUtil;
import com.example.reactive_web.security.SecurityUser;
import com.example.reactive_web.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Auther: changzhaoliang
 * @Date: 2018/11/26 17:47
 * @Description:
 */
@RestController
@RequestMapping("/api/reactive/auth")
public class AdminController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @PostMapping
    public Mono<ResponseEntity<String>> auth(String username, String password) {
        return userService.findByUsername(username).map((userDetails) -> {
            if (passwordEncoder.encode(password).equals(userDetails.getPassword())) {
                SecurityUser user = new SecurityUser();
                BeanUtils.copyProperties(userDetails,user);
                return ResponseEntity.ok(jwtUtil.generateToken(user));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        });
    }
}
