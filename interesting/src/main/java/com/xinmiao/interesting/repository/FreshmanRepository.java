package com.xinmiao.interesting.repository;

import com.xinmiao.interesting.entity.Freshman;
import org.springframework.data.jpa.repository.JpaRepository;

// 继承 JpaRepository，泛型第一个参数是实体类类型，第二个是主键类型
public interface FreshmanRepository extends JpaRepository<Freshman, Integer> {
    // 这里可以自定义符合 JPA 命名规范的查询方法，目前先使用默认的 CRUD 方法
}