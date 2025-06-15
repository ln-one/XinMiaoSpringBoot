package com.springrise.xinmiao.controller.preparation;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrise.xinmiao.dto.response.ApiResponse;
import com.springrise.xinmiao.dto.response.preparation.CampusFacilityResponse;
import com.springrise.xinmiao.dto.response.preparation.DocumentChecklistResponse;
import com.springrise.xinmiao.dto.response.preparation.LuggageListResponse;
import com.springrise.xinmiao.dto.response.preparation.TransportRouteResponse;
import com.springrise.xinmiao.service.preparation.CampusFacilityService;
import com.springrise.xinmiao.service.preparation.DocumentChecklistService;
import com.springrise.xinmiao.service.preparation.LuggageListService;
import com.springrise.xinmiao.service.preparation.TransportationService;
import com.springrise.xinmiao.util.JwtTokenUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/preparation")
@RequiredArgsConstructor
@Tag(name = "02-入学准备模块")
@SecurityRequirement(name = "Authorization") // 与SecurityConfig中的配置一致
public class PreparationController {

    private final JwtTokenUtil jwtTokenUtil;
    private final LuggageListService luggageListService;
    private final TransportationService transportationService;
    private final DocumentChecklistService documentChecklistService;
    private final CampusFacilityService campusFacilityService;

    // ========== 行李清单 ==========
    @Operation(summary = "生成行李清单", description = "基于生源地气候、专业特点生成个性化推荐")
    @GetMapping("/luggage")
    @PreAuthorize("hasRole('FRESHMAN')")
    public ApiResponse<LuggageListResponse> generateLuggageList(
            @Parameter(hidden = true) @RequestHeader("Authorization") String token) {
        return ApiResponse.success(
            luggageListService.generateLuggageList(
                jwtTokenUtil.extractUsername(token.replace("Bearer ", ""))
        ));
    }

    // ========== 交通路线 ==========
    @Operation(summary = "查询交通路线", description = "根据生源地推荐最优到校路线")
    @GetMapping("/transport")
    public ApiResponse<TransportRouteResponse> getTransportRoute(
            @RequestParam String originCity,
            @RequestParam(required = false) String preferredTransport) {
        return ApiResponse.success(
            transportationService.getRecommendedRoute(originCity, preferredTransport)
        );
    }

    // ========== 文件清单 ==========
    @Operation(summary = "获取文件清单")
    @GetMapping("/documents")
    public ApiResponse<List<DocumentChecklistResponse>> getDocumentChecklist(
            @Parameter(description = "学生类型: UNDERGRAD/GRADUATE/INTERNATIONAL") 
            @RequestParam String studentType) {
        return ApiResponse.success(
            documentChecklistService.getChecklistByType(studentType)
        );
    }

    @Operation(summary = "验证文件清单")
    @PostMapping("/documents/verify")
    @PreAuthorize("hasRole('FRESHMAN')")
    public ApiResponse<Boolean> verifyDocuments(
            @Parameter(hidden = true) @RequestHeader("Authorization") String token,
            @RequestBody List<String> documentIds) {
        return ApiResponse.success(
            documentChecklistService.verifyDocuments(
                jwtTokenUtil.extractUsername(token.replace("Bearer ", "")),
                documentIds
            )
        );
    }

    // ========== 校园设施 ==========
    @Operation(summary = "周边设施查询")
    @GetMapping("/facilities")
    public ApiResponse<List<CampusFacilityResponse>> getNearbyFacilities(
            @RequestParam(required = false) String facilityType) {
        return ApiResponse.success(
            campusFacilityService.getFacilitiesByCategory(facilityType)
        );
    }
}
