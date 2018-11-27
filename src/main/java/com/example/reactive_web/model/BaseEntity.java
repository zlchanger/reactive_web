package com.example.reactive_web.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: changzhaoliang
 * @Date: 2018/11/27 11:38
 * @Description:
 */
@Setter
@Getter
public class BaseEntity implements Serializable{

    @Id
    private String id;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private Date createdDate;

    @LastModifiedBy
    private String updatedBy;

    @LastModifiedDate
    private Date updatedDate;

    @Version
    private Long version;

    private Boolean status = true;
}
