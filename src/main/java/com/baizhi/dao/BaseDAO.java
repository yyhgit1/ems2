package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDAO<T> {
    void save(T t);

    void update(T t);

    void delete(String id);

    T findById(String id);

    List<T> findAll();

    Long findTotalCounts();

    //参数1：起始条数  参数2：每页显示记录数据
    List<T> findByPage(@Param("start") Integer start, @Param("size") Integer size);
}
