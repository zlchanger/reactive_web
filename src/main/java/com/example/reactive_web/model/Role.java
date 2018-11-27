package com.example.reactive_web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Auther: changzhaoliang
 * @Date: 2018/11/27 10:58
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "role")
public class Role extends BaseEntity{

    private String name;
    private String code;
}
