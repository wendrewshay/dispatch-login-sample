package com.eavescat.dispatch.login.sample.config;

import lombok.Data;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 自定义用户名密码凭据：增加了个登录类型
 * Created by wendrewshay on 2019/7/30 20:18
 */
@Data
public class CustomUsernamePasswordToken extends UsernamePasswordToken {
    /**
     * 登录类型：user-普通用户；admin-管理员
     */
    private String loginType;

    /**
     * Constructs a new UsernamePasswordToken encapsulating the username and password submitted
     * during an authentication attempt, with a <tt>null</tt> {@link #getHost() host} and a
     * <tt>rememberMe</tt> default of <tt>false</tt>.
     *
     * @param username the username submitted for authentication
     * @param password the password character array submitted for authentication
     */
    public CustomUsernamePasswordToken(String username, char[] password, String loginType) {
        super(username, password);
        this.loginType = loginType;
    }
}
