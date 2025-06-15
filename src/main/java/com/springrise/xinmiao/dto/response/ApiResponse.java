package com.springrise.xinmiao.dto.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ApiResponse<T> {
    private int code;       // 状态码（200=成功）
    private String message; // 提示信息
    private T data;         // 响应数据

    // 快速生成成功响应
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<T>()
            .setCode(200)
            .setMessage("success")
            .setData(data);
    }

    // 快速生成错误响应
    public static <T> ApiResponse<T> error(int code, String message) {
        return new ApiResponse<T>()
            .setCode(code)
            .setMessage(message);
    }
}
