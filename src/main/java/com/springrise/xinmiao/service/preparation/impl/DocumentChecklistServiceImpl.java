
package com.springrise.xinmiao.service.preparation.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springrise.xinmiao.dto.response.preparation.DocumentChecklistResponse;
import com.springrise.xinmiao.entity.preparation.DocumentRequirement;
import com.springrise.xinmiao.repository.mapper.DocumentRequirementMapper;
import com.springrise.xinmiao.repository.mapper.StudentDocumentMapper;
import com.springrise.xinmiao.service.preparation.DocumentChecklistService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocumentChecklistServiceImpl implements DocumentChecklistService {

    private final DocumentRequirementMapper requirementMapper;
    private final StudentDocumentMapper documentMapper;

    @Override
    public List<DocumentChecklistResponse> getChecklistByType(String studentType) {
        // 1. 查询该类型学生需要的文件清单
        List<DocumentRequirement> requirements = requirementMapper.selectByStudentType(studentType);
        
        // 2. 转换为响应DTO
        return requirements.stream()
            .map(req -> new DocumentChecklistResponse(
                req.getDocumentName(),
                req.isMandatory(),
                req.getDescription(), studentType
            ))
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean verifyDocuments(String studentId, List<String> documentIds) {
        // 1. 获取必交文件清单
        List<String> mandatoryDocs = requirementMapper.selectMandatoryDocs(studentId);
        
        // 2. 检查是否全部提交
        return documentIds.containsAll(mandatoryDocs);

    }

     
    
}
