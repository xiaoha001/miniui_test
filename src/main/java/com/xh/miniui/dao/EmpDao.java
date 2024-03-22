package com.xh.miniui.dao;

import com.xh.miniui.entity.Emp;

import java.util.List;

public interface EmpDao {

    List<Emp> search(String key, int pageIndex, int pageSize);

    List<Emp> getById(String id);

    boolean removeById(String id);

    boolean insertOneEmp(Emp emp);

    boolean updateOneEmp(Emp emp);
}
