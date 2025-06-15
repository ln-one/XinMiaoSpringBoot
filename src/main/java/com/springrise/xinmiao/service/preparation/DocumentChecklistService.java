// src/main/java/com/springrize/xinmiao/service/preparation/DocumentChecklistService.java
package com.springrise.xinmiao.service.preparation;

import com.springrise.xinmiao.dto.response.preparation.DocumentChecklistResponse;
import java.util.List;

public interface DocumentChecklistService {
    /**
     * 根据学生类型获取文件清单
     * @param studentType 学生类型 (UNDERGRADUATE/GRADUATE/INTERNATIONAL)
     */
    List<DocumentChecklistResponse> getChecklistByType(String studentType);

    /**
     * 验证学生文件是否齐全
     * @param studentId 学号
     * @param documentIds 已提交的文件ID列表
     */
    boolean verifyDocuments(String studentId, List<String> documentIds);
}
