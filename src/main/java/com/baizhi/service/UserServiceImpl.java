package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public void save(User user) {
        user.setId(UUID.randomUUID().toString());
        userDAO.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User findByUsernameAndPassword(String username, String password) {
        return userDAO.findByUsernameAndPassword(username, password);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }
}
