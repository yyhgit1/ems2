package com.baizhi.service;

import com.baizhi.dao.EmpDAO;
import com.baizhi.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDAO empDAO;

    @Override
    public void save(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        empDAO.save(emp);
    }

    @Override
    public void update(Emp emp) {
        empDAO.update(emp);
    }

    @Override
    public void delete(String id) {
        empDAO.delete(id);
    }

    public void deleteDid(String did) {
        empDAO.deleteDid(did);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Emp findById(String id) {
        return empDAO.findById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Emp> findAll(String did) {
        return empDAO.findAll(did);
    }
}
