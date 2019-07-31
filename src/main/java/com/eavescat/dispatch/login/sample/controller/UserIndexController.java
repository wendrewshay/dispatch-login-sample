package com.eavescat.dispatch.login.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 普通用户端首页视图控制器
 * Created by wendrewshay on 2019/7/30 16:02
 */
@Controller
public class UserIndexController {

    /**
     * 前台首页
     * @author wendrewshay
     * @date 2019/7/30 16:03
     * @return String
     */
    @GetMapping("/user/index")
    public String userIndex() {
        return "userIndex";
    }
}
