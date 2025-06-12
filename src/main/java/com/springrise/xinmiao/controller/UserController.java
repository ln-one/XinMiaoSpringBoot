package com.springrise.xinmiao.controller;

import com.springrise.xinmiao.model.dto.*;
import com.springrise.xinmiao.model.entity.User;
import com.springrise.xinmiao.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * 用户认证模块 Controller
 */
@RestController
@RequestMapping("/api/auth")
@Tag(name = "Auth", description = "用户认证相关接口")
@RequiredArgsConstructor
public class UserController {
    private final AuthService authService;

    @Operation(summary = "新生注册")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegistrationRequest req) {
        authService.register(req);
        return ResponseEntity.ok("注册成功");
    }

    @Operation(summary = "登录")
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest req) {
        AuthResponse resp = authService.login(req);
        return ResponseEntity.ok(resp);
    }

    @Operation(summary = "登出")
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String refreshToken) {
        authService.logout(refreshToken);
        return ResponseEntity.ok("已登出");
    }

    @Operation(summary = "密码找回")
    @PostMapping("/password/reset")
    public ResponseEntity<String> resetPassword(@RequestBody PasswordResetRequest req) {
        authService.resetPassword(req);
        return ResponseEntity.ok("密码已重置");
    }

    @Operation(summary = "获取个人信息")
    @GetMapping("/profile/{uid}")
    public ResponseEntity<User> getProfile(@PathVariable Integer uid) {
        Optional<User> user = authService.getProfile(uid);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "更新个人信息")
    @PutMapping("/profile")
    public ResponseEntity<String> updateProfile(
        @RequestParam Integer uid,
        @RequestBody ProfileUpdateRequest req) {
        authService.updateProfile(uid, req);
        return ResponseEntity.ok("个人信息更新成功");
    }
}