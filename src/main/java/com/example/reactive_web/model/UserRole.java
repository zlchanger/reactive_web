package com.example.reactive_web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Auther: changzhaoliang
 * @Date: 2018/11/27 13:08
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "userRole")
public class UserRole {

    @Id
    private String id;

    private String userId;
    private String roleId;
}
