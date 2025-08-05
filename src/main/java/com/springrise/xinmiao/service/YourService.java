package com.springrise.xinmiao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrise.xinmiao.util.JwtTokenUtil;

@Service
public class YourService {
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public String extractUsernameFromToken(String token) {
        return jwtTokenUtil.extractUsername(token);
    }
    
    // 其他业务方法...
}
