package com.example.reactive_web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class User extends BaseEntity{

    private String admin;
    private String password;
    
}
