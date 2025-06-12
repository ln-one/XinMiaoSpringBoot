package com.springrise.xinmiao.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 个人信息更新请求 DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "个人信息更新请求 DTO")
public class ProfileUpdateRequest {
    // 用户名必填项匹配Uname非空约束
    @Schema(description = "用户名", required = true)
    private String uname;

    // 手机号可选项匹配Uphone允许NULL
    @Schema(description = "手机号", required = false)
    private String uphone;

    // 邮箱必填项匹配Uemail非空约束
    @Schema(description = "邮箱", required = true)
    private String uemail;
}
