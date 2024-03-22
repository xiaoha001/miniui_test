package com.xh.miniui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/home")
    public String home() {
        return "index"; // 逻辑视图名称为 "index"
    }

}
