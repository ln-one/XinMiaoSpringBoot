package com.springrise.xinmiao.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * 用户实体，映射数据库用户表
 * 班级：2023级软件工程-02班  姓名：张春冉
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "用户实体")
public class User {
    // Uid主键字段匹配
    private Integer uid; 

    // Uname用户名字段匹配
    private String uname;

    // Upassword密码哈希字段匹配（char64）
    private String upassword;

    // Uemail邮箱字段匹配（varchar100）
    private String uemail;

    // Uphone手机号字段匹配（varchar20）
    private String uphone;

    // Uregtime注册时间字段匹配（datetime）
    private LocalDateTime uregtime;

    // Uidcard身份证号字段匹配（char18）
    private String uidcard;
}
