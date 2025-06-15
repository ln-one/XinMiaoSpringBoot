package com.xinmiao.interesting.repository;

import com.xinmiao.interesting.entity.CampusEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampusEventRepository extends JpaRepository<CampusEvent, Integer> {
}