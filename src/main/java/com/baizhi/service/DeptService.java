package com.baizhi.service;

import com.baizhi.entity.Dept;

import java.util.List;

public interface DeptService {
    void save(Dept dept);

    void update(Dept dept);

    void delete(String id);

    Dept findById(String id);

    List<Dept> findAll();
}
