package com.springrise.xinmiao.service.preparation;

import java.util.List;

import com.springrise.xinmiao.dto.response.preparation.LuggageItemDTO;
import com.springrise.xinmiao.dto.response.preparation.LuggageListResponse;

public interface LuggageListService {
    LuggageListResponse generateLuggageList(String studentId);
    void saveCustomizedList(String studentId, List<LuggageItemDTO> items);
}