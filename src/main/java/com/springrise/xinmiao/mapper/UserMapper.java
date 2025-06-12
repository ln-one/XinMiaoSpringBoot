package com.springrise.xinmiao.mapper;

import com.springrise.xinmiao.model.entity.User;
import org.apache.ibatis.annotations.*;
import java.util.Optional;

/**
 * UserMapper 接口
 */
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO `User` (Uname, Upassword, Uemail, Uphone, Uidcard) VALUES (#{uname}, #{upassword}, #{uemail}, #{uphone}, #{uidcard})")
    @Options(useGeneratedKeys = true, keyProperty = "uid")
    int insert(User user);

    @Select("SELECT * FROM `User` WHERE Uemail = #{email}")
    @ResultMap("userResult")
    Optional<User> findByEmail(@Param("email") String email);

    @Select("SELECT * FROM `User` WHERE Uid = #{uid}")
    @ResultMap("userResult")
    Optional<User> findById(@Param("uid") Integer uid);

    @Select("SELECT * FROM `User` WHERE Uname = #{u} OR Uemail = #{u}")
    @Results(id = "userResult", value = {
            @Result(property = "uid", column = "Uid"),
            @Result(property = "uname", column = "Uname"),
            @Result(property = "upassword", column = "Upassword"),
            @Result(property = "uemail", column = "Uemail"),
            @Result(property = "uphone", column = "Uphone"),
            @Result(property = "uregtime", column = "Uregtime"),
            @Result(property = "uidcard", column = "Uidcard")
    })
    Optional<User> findByUsernameOrEmail(@Param("u") String u);

    @Update("UPDATE `User` SET Upassword = #{upassword} WHERE Uemail = #{email} AND Uidcard = #{uidcard}")
    int updatePasswordByEmailAndIdCard(@Param("email") String email, @Param("uidcard") String uidcard, @Param("upassword") String newHash);


    // 更新语句字段匹配验证
    @Update("UPDATE `User` SET "
    + "Uname = #{uname}, "        // 匹配Uname字段
    + "Uphone = #{uphone}, "      // 匹配Uphone字段 
    + "Uemail = #{uemail} "       // 匹配Uemail字段
    + "WHERE Uid = #{uid}")       // 主键条件匹配
    int updateProfile(User user);
}