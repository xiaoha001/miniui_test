package com.xh.miniui.controller;

import com.xh.miniui.entity.Emp;
import com.xh.miniui.service.EmpService;
import com.xh.miniui.utils.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @ResponseBody
    @RequestMapping(value = "/EmpController")
    public String SearchEmployees(@RequestParam(value = "key", required = false, defaultValue = "") String key,
                                  @RequestParam(value = "pageIndex", required = false, defaultValue = "0") int pageIndex,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize,
                                  @RequestParam(value = "sortField", required = false, defaultValue = "0") int sortField,
                                  @RequestParam(value = "sortOrder", required = false, defaultValue = "0") int sortOrder) throws Exception{

        List<Emp> res = empService.searchEmpResult(key, pageIndex, pageSize, sortField, sortOrder);
        String json = JSON.encode(res);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/SearchAllEmp", method = {RequestMethod.GET, RequestMethod.POST})
    public String SearchEmployees() throws Exception{
        List<Emp> res = empService.searchEmpResult("", 0, 0, 0, 0);
        String json = JSON.encode(res);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/GetOneEmp", method = {RequestMethod.GET, RequestMethod.POST})
    public String GetOneEmp(@RequestParam(value = "id", required = true) String id) throws Exception{
        List<Emp> res = empService.getEmpById(id);
        String json = JSON.encode(res.get(0));
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/RemoveOneEmp", method = {RequestMethod.GET, RequestMethod.POST})
    public boolean RemoveOneEmp(@RequestParam(value = "id", required = true) String id) throws Exception{
        boolean res = empService.removeEmpById(id);
        return res;
    }

    @ResponseBody
    @PostMapping("/SaveOneEmp")
    public boolean SaveOneEmp(@RequestBody Emp emp) throws Exception{
        boolean res = empService.SaveOneEmp(emp);
        return res;
    }

}
