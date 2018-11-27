package com.example.reactive_web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

/**
 * @Auther: changzhaoliang
 * @Date: 2018/11/27 11:27
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "resource")
public class Resource extends BaseEntity{

    @NotNull
    private String url;
    private String permission;
    private String name;

}
