package com.xinmiao.interesting.controller;

import com.xinmiao.interesting.entity.Club;
import com.xinmiao.interesting.entity.CampusEvent;
import com.xinmiao.interesting.entity.Freshman;
import com.xinmiao.interesting.service.DatabaseService;
import com.xinmiao.interesting.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RecommendationController {

    @Autowired
    private DatabaseService databaseService;

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/freshmen")
    public List<Freshman> getAllFreshmen() {
        return databaseService.getAllFreshmen();
    }

    @GetMapping("/clubs")
    public List<Club> getAllClubs() {
        return databaseService.getAllClubs();
    }

    @GetMapping("/events")
    public List<CampusEvent> getAllCampusEvents() {
        return databaseService.getAllCampusEvents();
    }

    @GetMapping("/freshmen/{id}/recommended-clubs")
    public List<Club> getRecommendedClubs(@PathVariable int id) {
        Optional<Freshman> freshmanOptional = databaseService.getAllFreshmen().stream()
                .filter(f -> f.getUid() == id)
                .findFirst();
        if (freshmanOptional.isPresent()) {
            return recommendationService.recommendClubs(freshmanOptional.get());
        }
        // 这里可根据实际需求处理不存在的情况，比如抛自定义异常或返回空列表等
        return List.of();
    }

    @GetMapping("/freshmen/{id}/recommended-events")
    public List<CampusEvent> getRecommendedEvents(@PathVariable int id) {
        Optional<Freshman> freshmanOptional = databaseService.getAllFreshmen().stream()
                .filter(f -> f.getUid() == id)
                .findFirst();
        if (freshmanOptional.isPresent()) {
            return recommendationService.recommendEvents(freshmanOptional.get());
        }
        // 这里可根据实际需求处理不存在的情况，比如抛自定义异常或返回空列表等
        return List.of();
    }
}