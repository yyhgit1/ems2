package com.baizhi.service;

import com.baizhi.entity.Emp;

import java.util.List;

public interface EmpService {
    void save(Emp emp);

    void update(Emp emp);

    void delete(String id);

    void deleteDid(String did);

    Emp findById(String id);

    List<Emp> findAll(String did);
}
