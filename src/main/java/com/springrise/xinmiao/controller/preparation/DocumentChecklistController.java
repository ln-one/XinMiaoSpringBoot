package com.springrise.xinmiao.controller.preparation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrise.xinmiao.dto.response.ApiResponse;
import com.springrise.xinmiao.dto.response.preparation.DocumentChecklistResponse;
import com.springrise.xinmiao.service.preparation.DocumentChecklistService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/preparation/documents")
@RequiredArgsConstructor
public class DocumentChecklistController {

    private final DocumentChecklistService documentService = null;

    @GetMapping
    public ApiResponse<List<DocumentChecklistResponse>> getChecklist(
            @RequestParam String studentType) {
        return ApiResponse.success(documentService.getChecklistByType(studentType));
    }

    @PostMapping("/verify")
    public ApiResponse<Boolean> verifyDocuments(
            @RequestParam String studentId,
            @RequestBody List<String> documentIds) {
        return ApiResponse.success(
            documentService.verifyDocuments(studentId, documentIds)
        );
    }
}
