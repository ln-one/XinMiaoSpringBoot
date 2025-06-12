package com.springrise.xinmiao.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 注册请求 DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "注册请求 DTO")
public class RegistrationRequest {
    @Schema(description = "用户名", required = true)
    private String uname;

    @Schema(description = "明文密码", required = true)
    private String password;

    @Schema(description = "邮箱", required = true)
    private String uemail;

    @Schema(description = "手机号", required = false)
    private String uphone;

    @Schema(description = "身份证号", required = true)
    private String uidcard;
}