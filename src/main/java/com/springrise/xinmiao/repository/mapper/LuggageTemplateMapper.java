package com.springrise.xinmiao.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.springrise.xinmiao.entity.preparation.LuggageTemplate;

@Mapper
public interface LuggageTemplateMapper {
    List<LuggageTemplate> selectByConditions(
        @Param("climateZone") String climateZone,
        @Param("majorCategory") String majorCategory);
}
