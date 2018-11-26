package com.example.reactive_web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Auther: changzhaoliang
 * @Date: 2018/11/20 18:18
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "semester")
public class Semester {
    @Id
    private String id;

    private String academicYear;
    private Byte semesterType=1;
    private Date startDate;
    private Date endDate;
    private Long schoolId;
    private Long version;
    private Byte status=1;
    private Byte currentType=0;

    @NotNull
    private Date createTime;
    @NotNull
    private Date modifyTime;
}
