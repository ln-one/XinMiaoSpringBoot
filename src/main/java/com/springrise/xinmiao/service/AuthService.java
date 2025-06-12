package com.springrise.xinmiao.service;

import com.springrise.xinmiao.model.dto.*;
import com.springrise.xinmiao.model.entity.User;

import java.util.Optional;

/**
 * 用户认证服务接口
 */
public interface AuthService {
    void register(RegistrationRequest req);
    AuthResponse login(LoginRequest req);
    void logout(String refreshToken);
    void resetPassword(PasswordResetRequest req);
    Optional<User> getProfile(Integer uid);
    void updateProfile(Integer uid, ProfileUpdateRequest req);
}
