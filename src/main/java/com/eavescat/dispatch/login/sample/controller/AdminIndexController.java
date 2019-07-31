package com.eavescat.dispatch.login.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 后台首页视图控制器
 * Created by wendrewshay on 2019/7/30 16:02
 */
@Controller
public class AdminIndexController {

    /**
     * 默认首页
     * @author wendrewshay
     * @date 2019/7/30 16:03
     * @return String
     */
    @GetMapping("/admin/index")
    public String defaultIndex() {
        return "adminIndex";
    }

}
