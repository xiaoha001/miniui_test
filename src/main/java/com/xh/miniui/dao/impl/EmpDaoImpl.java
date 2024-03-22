package com.xh.miniui.dao.impl;

import com.xh.miniui.dao.EmpDao;
import com.xh.miniui.entity.Emp;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class EmpDaoImpl implements EmpDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

//    @Override
//    public List<Emp> search(String key, int pageIndex, int pageSize) {
//
//        String hql = "FROM Emp e WHERE e.name LIKE '%"+key+"%'";
//        Query query = getCurrentSession().createQuery(hql);
//        query.setFirstResult(pageIndex); // 第一条记录，记录的起始位置（>0）
//        query.setMaxResults(pageSize);  // 最大记录数
//        List<Emp> list = query.list();
//
//        return list;
//    }

    @Override
    public List<Emp> search(String key, int pageIndex, int pageSize) {
        Session session = getCurrentSession();

        try {
            String hql = "FROM Emp e WHERE e.name LIKE :key";
            Query query = session.createQuery(hql);
            query.setParameter("key", "%" + key + "%");
            query.setFirstResult(pageIndex * pageSize);
            query.setMaxResults(pageSize);
            return query.list();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Emp> getById(String id) {
        Session session = getCurrentSession();

        try {
            String hql = "FROM Emp e WHERE e.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            return query.list();
        } finally {
            session.close();
        }
    }

//    @Override
//    public List<Emp> getById(String id) {
//
//        String hql = "FROM Emp e WHERE e.id = @id";
//        Query query = getCurrentSession().createQuery(hql);
//
//        query.setParameter("id", id);
//        Object obj = query.uniqueResult();
//        Emp emp = (Emp) obj ;
//        List<Emp> list = new ArrayList<>();
//        list.add(emp);
//
//        return list;
//    }

    @Override
    public boolean removeById(String id) {
        Session session = getCurrentSession();
        Transaction tx = null;
        boolean removed = false;

        try {
            tx = session.beginTransaction();
            Emp emp = (Emp) session.get(Emp.class, id);
            if (emp != null) {
                session.delete(emp);
                removed = true;
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return removed;
    }

    @Override
    public boolean insertOneEmp(Emp emp) {
        Session session = getCurrentSession();
        Transaction tx = null;
        boolean success = false;

        try {
            tx = session.beginTransaction();
            session.save(emp);
            tx.commit();
            success = true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return success;
    }

    @Override
    public boolean updateOneEmp(Emp emp) {
        Session session = getCurrentSession();
        Transaction tx = null;
        boolean success = false;

        try {
            tx = session.beginTransaction();
            session.update(emp);
            tx.commit();
            success = true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return success;
    }


}
