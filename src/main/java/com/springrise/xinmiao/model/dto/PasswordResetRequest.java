package com.springrise.xinmiao.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 密码找回请求 DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "密码找回请求 DTO")
public class PasswordResetRequest {
    @Schema(description = "邮箱", required = true)
    private String useridcardOrEmail;  // 邮箱

    @Schema(description = "身份证号", required = true)
    private String uidcard;            // 用户的身份证号

    @Schema(description = "新密码", required = true)
    private String newPassword;        // 新密码
}
