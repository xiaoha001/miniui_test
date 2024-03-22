package com.xh.miniui.service.impl;

import com.xh.miniui.dao.EmpDao;
import com.xh.miniui.entity.Emp;
import com.xh.miniui.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;


    @Override
    public List<Emp> searchEmpResult(String key, int pageIndex, int pageSize, int sortField, int sortOrder) {
        return empDao.search(key,pageIndex,pageSize);
    }

    @Override
    public List<Emp> getEmpById(String id) {
        return empDao.getById(id);
    }

    @Override
    public boolean removeEmpById(String id) {
        return empDao.removeById(id);
    }

    @Override
    public boolean SaveOneEmp(Emp emp) {
        String id = emp.getId() != null ? emp.getId() : "";
        String state = emp.get_state() != null ? emp.get_state() : "";

        if(state.equals("added") || id.equals("")){
            //新增：id为空 或 _state为added
            emp.setCreatetime(String.valueOf(new Date()));
            return empDao.insertOneEmp(emp);
        }else if (state.equals("removed") || state.equals("deleted")) {
            //删除：_state为removed 或 deleted
            return empDao.removeById(id);
        }else if (state.equals("modified") || state.equals("")) {
            //更新：_state为空 或 modified
            return empDao.updateOneEmp(emp);
        }
        return true;
    }

}
