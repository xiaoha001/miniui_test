package com.xh.miniui.service.impl;

import com.xh.miniui.dao.UserDao;
import com.xh.miniui.entity.User;
import com.xh.miniui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findUsers() {
        return userDao.findUsers();
    }

    @Override
    public int saveUser(User entity) {
        entity.setAddress("tztztztztz");
        entity.setUsername("张三");
        entity.setPhone("12345674567");
        return userDao.saveUser(entity);
    }
}

