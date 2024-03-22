package com.xh.miniui.dao;

import com.xh.miniui.entity.User;
import java.util.List;

public interface UserDao {
    List<User> findUsers();

    int saveUser(User entity);
}

