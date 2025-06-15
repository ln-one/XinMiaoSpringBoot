package com.xinmiao.interesting.service;

import com.xinmiao.interesting.entity.Club;
import com.xinmiao.interesting.entity.CampusEvent;
import com.xinmiao.interesting.entity.Freshman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    @Autowired
    private DatabaseService databaseService;

    public List<Club> recommendClubs(Freshman freshman) {
        // 这里只是简单示例，返回所有社团，实际可根据复杂逻辑（如兴趣匹配等）实现推荐
        return databaseService.getAllClubs();
    }

    public List<CampusEvent> recommendEvents(Freshman freshman) {
        // 这里只是简单示例，返回所有校园活动，实际可根据复杂逻辑（如时间、兴趣匹配等）实现推荐
        return databaseService.getAllCampusEvents();
    }
}