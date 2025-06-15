package com.xinmiao.interesting.service;

import com.xinmiao.interesting.entity.Club;
import com.xinmiao.interesting.entity.CampusEvent;
import com.xinmiao.interesting.entity.Freshman;
import com.xinmiao.interesting.repository.ClubRepository;
import com.xinmiao.interesting.repository.CampusEventRepository;
import com.xinmiao.interesting.repository.FreshmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseService {

    @Autowired
    private FreshmanRepository freshmanRepository;

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private CampusEventRepository campusEventRepository;

    public List<Freshman> getAllFreshmen() {
        return freshmanRepository.findAll();
    }

    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    public List<CampusEvent> getAllCampusEvents() {
        return campusEventRepository.findAll();
    }
}