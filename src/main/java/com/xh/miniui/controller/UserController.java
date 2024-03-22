package com.xh.miniui.controller;

import com.xh.miniui.entity.User;
import com.xh.miniui.service.EmpService;
import com.xh.miniui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUsers")
    public String findUsers(Model model){
        List<User> users = userService.findUsers();
        model.addAttribute("users",users);
        return "user";
    }

    @RequestMapping("/saveUser")
    public String saveUsser(){
        User user = new User();
        userService.saveUser(user);
        return "success";
    }
}

