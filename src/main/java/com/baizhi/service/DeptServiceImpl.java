package com.baizhi.service;

import com.baizhi.dao.DeptDAO;
import com.baizhi.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDAO deptDAO;

    @Override
    public void save(Dept dept) {
        dept.setId(UUID.randomUUID().toString());
        deptDAO.save(dept);
    }

    @Override
    public void update(Dept dept) {
        deptDAO.update(dept);
    }

    @Override
    public void delete(String id) {
        deptDAO.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Dept findById(String id) {
        return deptDAO.findById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Dept> findAll() {
        return deptDAO.findAll();
    }
}
