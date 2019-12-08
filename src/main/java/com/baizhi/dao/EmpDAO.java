package com.baizhi.dao;

import com.baizhi.entity.Emp;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmpDAO extends BaseDAO<Emp> {
    List<Emp> findAll(String did);

    void deleteDid(String did);
}
