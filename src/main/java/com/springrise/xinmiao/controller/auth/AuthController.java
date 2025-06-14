package com.springrise.xinmiao.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.springrise.xinmiao.util.JwtTokenUtil;

// src/main/java/com/springrize/xinmiao/controller/AuthController.java
@RestController
public class AuthController {

    @Autowired // 自动注入
    private JwtTokenUtil jwtTokenUtil; 

    @GetMapping("/validate")
    public ResponseEntity<?> validate(@RequestHeader String token) {
        String username = jwtTokenUtil.extractUsername(token); // ✅ 正确调用
        return ResponseEntity.ok(username);
    }
}
