package com.huiyu.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xujie
 */
@Controller
@RequestMapping("/test")
public class TestController {


    @RequestMapping("list")
    @ResponseBody
    public Object list() {
        return "hello world";
    }
}
