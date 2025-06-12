package com.springrise.xinmiao.service;

import com.springrise.xinmiao.mapper.UserMapper;
import com.springrise.xinmiao.model.dto.*;
import com.springrise.xinmiao.model.entity.User;
import com.springrise.xinmiao.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * 用户认证服务实现
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserMapper userMapper;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void register(RegistrationRequest req) {
        String hash = passwordEncoder.encode(req.getPassword());
        User user = new User(null, req.getUname(), hash, req.getUemail(), req.getUphone(), LocalDateTime.now(), req.getUidcard());
        userMapper.insert(user);
    }

    @Override
    public AuthResponse login(LoginRequest req) {
        User user = userMapper.findByUsernameOrEmail(req.getUseridcardOrEmail())
                .orElseThrow(() -> new RuntimeException("用户不存在"));
        if (!passwordEncoder.matches(req.getPassword(), user.getUpassword())) {
            throw new RuntimeException("用户名或密码错误");
        }
        String token = jwtUtil.generateToken(user.getUid().toString());
        String refresh = jwtUtil.generateToken("REFRESH_" + user.getUid());
        long exp = System.currentTimeMillis() / 1000 + 3600;
        return new AuthResponse(user.getUid(), token, refresh, exp);
    }

    @Override
    public void logout(String refreshToken) {
        // TODO: 实现刷新令牌作废，如 Redis 黑名单
    }

    @Override
    public void resetPassword(PasswordResetRequest req) {
        // 使用邮箱和身份证校验
        String hash = passwordEncoder.encode(req.getNewPassword());
        int updatedRows = userMapper.updatePasswordByEmailAndIdCard(req.getUseridcardOrEmail(), req.getUidcard(), hash);

        if (updatedRows == 0) {
            throw new RuntimeException("邮箱或身份证信息不匹配，无法重置密码");
        }
    }

    @Override
    public Optional<User> getProfile(Integer uid) {
        return userMapper.findById(uid);
    }

    @Override
    public void updateProfile(Integer uid, ProfileUpdateRequest req) {
        User u = new User(uid, req.getUname(), null, req.getUemail(), req.getUphone(), null, null);
        userMapper.updateProfile(u);
    }
}