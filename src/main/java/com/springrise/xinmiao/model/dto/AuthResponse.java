package com.springrise.xinmiao.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 认证响应 DTO，包含访问和刷新令牌及过期时间
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "认证响应 DTO")
public class AuthResponse {
    @Schema(description = "用户唯一标识")
    private Integer uid;
    
    @Schema(description = "JWT 访问令牌")
    private String accessToken;

    @Schema(description = "刷新令牌")
    private String refreshToken;

    @Schema(description = "访问令牌过期时间，UTC 时间戳")
    private Long expiresAt;
}