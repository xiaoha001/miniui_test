package com.xh.miniui.service;

import com.xh.miniui.entity.Emp;

import java.util.HashMap;
import java.util.List;

public interface EmpService {

    List<Emp> searchEmpResult(String key, int pageIndex, int pageSize, int sortField, int sortOrder);

    List<Emp> getEmpById(String id);

    boolean removeEmpById(String id);

    boolean SaveOneEmp(Emp emp);
}
