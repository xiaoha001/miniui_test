package com.xh.miniui.dao.impl;

import com.xh.miniui.dao.UserDao;
import com.xh.miniui.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    @Override
    public int saveUser(User entity) {
        int id = (Integer) getCurrentSession().save(entity);
        return id;
    }
    @Override
    public List<User> findUsers() {
        Query query = getCurrentSession().createQuery("from User");
        List<User> list = query.list();
        return list;
    }
}

