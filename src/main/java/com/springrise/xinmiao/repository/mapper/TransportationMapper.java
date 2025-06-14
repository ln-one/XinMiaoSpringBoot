package com.springrise.xinmiao.repository.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.springrise.xinmiao.entity.preparation.TransportRoute;

@Mapper
public interface TransportationMapper {
    @Select("SELECT * FROM transport_routes WHERE origin_city = #{city} " +
            "AND (#{preferredTransport} IS NULL OR transport_type = #{preferredTransport})")
    TransportRoute selectRoute(@Param("city") String city, 
                             @Param("preferredTransport") String preferredTransport);
}
