package com.eavescat.dispatch.login.sample.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户视图控制器
 * Created by wendrewshay on 2019/7/30 11:11
 */
@Controller
@RequestMapping("/user/students")
public class StudentsController {

    /**
     * 测试权限- 改成user:show可正常访问
     * @author wendrewshay
     * @date 2019/7/30 11:16
     * @return String
     */
    @RequiresPermissions("user:select")
    @ResponseBody
    @RequestMapping("/show")
    public String showUser() {
        return "这是学生信息";
    }
}
