package com.example.reactive_web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Auther: changzhaoliang
 * @Date: 2018/11/26 18:00
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User {

    @Id
    private String id;

    private String admin;
    private String password;
    
    private Boolean enabled=true;
}
