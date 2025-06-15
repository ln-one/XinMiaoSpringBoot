package com.springrise.xinmiao.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.springrise.xinmiao.entity.preparation.CampusFacility;

@Mapper
public interface CampusFacilityMapper {
    // 基础CRUD
    @Insert("INSERT INTO campus_facilities(name, category, address, latitude, longitude, " +
            "open_hours, contact_phone, thumbnail_url, rating, status) " +
            "VALUES(#{name}, #{category}, #{address}, #{latitude}, #{longitude}, " +
            "#{openHours}, #{contactPhone}, #{thumbnailUrl}, #{rating}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(CampusFacility facility);

    @Select("SELECT * FROM campus_facilities WHERE id = #{id}")
    CampusFacility selectById(Long id);

    // 条件查询
    @Select("<script>" +
            "SELECT * FROM campus_facilities WHERE status = 1 " +
            "<if test='category != null'> AND category = #{category} </if>" +
            "<if test='keyword != null'> AND name LIKE CONCAT('%',#{keyword},'%') </if>" +
            "ORDER BY rating DESC LIMIT 100" +
            "</script>")
    List<CampusFacility> selectByConditions(
        @Param("category") String category,
        @Param("keyword") String keyword);



    @Select("SELECT *, " +
           "ST_Distance_Sphere(" +
           "  POINT(#{longitude}, #{latitude}), " +
           "  POINT(longitude, latitude)" +
           ") AS distance " +
           "FROM campus_facilities " +
           "WHERE status = 1 " +
           "AND (#{type} IS NULL OR category = #{type}) " +
           "HAVING distance <= #{radius} " +
           "ORDER BY distance")
    List<CampusFacility> selectNearbyFacilities(
        @Param("longitude") Double longitude,
        @Param("latitude") Double latitude,
        @Param("radius") Double radius,
        @Param("type") String type);
}
