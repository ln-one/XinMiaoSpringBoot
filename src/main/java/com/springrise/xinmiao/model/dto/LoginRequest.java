package com.springrise.xinmiao.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录请求 DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "登录请求 DTO")
public class LoginRequest {
    @Schema(description = "身份证号或邮箱", required = true)
    private String useridcardOrEmail;

    @Schema(description = "密码", required = true)
    private String password;
}