package com.springrise.xinmiao.external;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.springrise.xinmiao.external.dto.MapApiResponse;

@Component
public class MapApiClient {
    private final RestTemplate restTemplate;
    private final String apiKey;
    private final String apiEndpoint;

    
    public MapApiClient(
        RestTemplate restTemplate,
        @Value("${map.api.key}") String apiKey,
        @Value("${map.api.endpoint}") String apiEndpoint
    ) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
        this.apiEndpoint = apiEndpoint;
    }

    /**
     * 获取路线规划
     * @param origin 出发地
     * @param destination 目的地（固定为学校）
     * @param transportType 交通方式
     * @return 路线数据
     */
    public MapApiResponse getRoute(String origin, String destination, String transportType) {
        try {
            String url = String.format("%s/direction?origin=%s&destination=%s&mode=%s&key=%s",
                apiEndpoint,
                URLEncoder.encode(origin, StandardCharsets.UTF_8),
                URLEncoder.encode(destination, StandardCharsets.UTF_8),
                transportType,
                apiKey);

            return restTemplate.getForObject(url, MapApiResponse.class);
        } catch (RestClientException e) {
            throw new MapApiException();
        }
    }
}