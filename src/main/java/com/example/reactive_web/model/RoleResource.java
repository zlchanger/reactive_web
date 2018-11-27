package com.example.reactive_web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Auther: changzhaoliang
 * @Date: 2018/11/27 13:07
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "roleResource")
public class RoleResource{

    @Id
    private String id;

    private String roleId;
    private String resourceId;
}
