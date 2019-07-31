package com.eavescat.dispatch.login.sample.controller;

import com.eavescat.dispatch.login.sample.config.CustomUsernamePasswordToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 普通用户端登录视图控制
* Created by wendrewshay on 2019/7/30 10:50
 */
@Controller
public class UserLoginController {

    /**
     * 前台登录页
     * @author wendrewshay
     * @date 2019/7/30 10:52
     * @return String
     */
    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String userLogin() {
        return "userLogin";
    }

    /**
     * 前台登录
     * @author wendrewshay
     * @date 2019/7/30 10:52
     * @param username 用户名
     * @param password 密码
     * @return String
     */
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletResponse response) throws IOException {
        Subject subject = SecurityUtils.getSubject();
        CustomUsernamePasswordToken token = new CustomUsernamePasswordToken(username, password.toCharArray(), "user");
        try {
            subject.login(token);
        } catch (AuthenticationException ae) {
            return "用户名或密码不正确！";
        }
        if (subject.isAuthenticated()) {
            response.sendRedirect("/user/index");
            return "登录成功";
        } else {
            token.clear();
            return "登录失败";
        }
    }

    /**
     * 登出
     * @author wendrewshay
     * @date 2019/7/31 14:13
     * @return String
     */
    @GetMapping("/user/logout")
    public String userLogout() {
        SecurityUtils.getSubject().logout();
        return "redirect:/user/login";
    }
}
