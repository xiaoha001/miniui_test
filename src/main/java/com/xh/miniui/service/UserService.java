package com.xh.miniui.service;

import com.xh.miniui.entity.User;

import java.util.List;

public interface UserService {

    List<User> findUsers();

    int saveUser(User entity);
}

