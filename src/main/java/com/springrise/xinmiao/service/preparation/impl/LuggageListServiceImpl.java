package com.springrise.xinmiao.service.preparation.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springrise.xinmiao.dto.response.preparation.LuggageItemDTO;
import com.springrise.xinmiao.dto.response.preparation.LuggageListResponse;
import com.springrise.xinmiao.dto.response.preparation.LuggageListResponse.LuggageItem;
import com.springrise.xinmiao.entity.StudentProfile;
import com.springrise.xinmiao.entity.preparation.LuggageTemplate;
import com.springrise.xinmiao.repository.mapper.LuggageTemplateMapper;
import com.springrise.xinmiao.service.StudentProfileService;
import com.springrise.xinmiao.service.preparation.LuggageListService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LuggageListServiceImpl implements LuggageListService {
    
    private final LuggageTemplateMapper luggageTemplateMapper = null;
    private final StudentProfileService studentProfileService;

    @Override
    public LuggageListResponse generateLuggageList(String username) {
        // 1. 获取学生资料（生源地、专业等）
        StudentProfile profile = studentProfileService.getProfile(username);
        
        // 2. 查询行李模板
        List<LuggageTemplate> templates = luggageTemplateMapper.selectByConditions(
            profile.getClimateZone(), 
            profile.getMajorCategory()
        );
        
        // 3. 组装响应
        return LuggageListResponse.builder()
            .essentials(filterEssentialItems(templates))
            .recommendations((List<LuggageItem>) filterRecommendedItems(templates))
            .build();
    }

    private List<LuggageItem> filterEssentialItems(List<LuggageTemplate> templates) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filterEssentialItems'");
    }

    private Object filterRecommendedItems(List<LuggageTemplate> templates) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filterRecommendedItems'");
    }

    @Override
    public void saveCustomizedList(String studentId, List<LuggageItemDTO> items) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveCustomizedList'");
    }
}
