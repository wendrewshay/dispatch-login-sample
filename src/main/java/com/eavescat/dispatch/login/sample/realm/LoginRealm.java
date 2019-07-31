package com.eavescat.dispatch.login.sample.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户认证和权限校验
 * Created by wendrewshay on 2019/7/31 16:14
 */
public class LoginRealm extends AuthorizingRealm {

    public LoginRealm(String name) {
        super.setName(name);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<>();
        Set<String> perms = new HashSet<>();
        if ("admin".equalsIgnoreCase(username)) {
            roles.add("admin");
            perms.add("admin:select");
            perms.add("admin:update");
        } else if ("user".equalsIgnoreCase(username)) {
            roles.add("user");
            perms.add("user:select");
            perms.add("user:update");
        }
        info.setRoles(roles);
        info.setStringPermissions(perms);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();
        String password = new String((char[])token.getCredentials());
        if (!"admin".equalsIgnoreCase(username) && !"user".equalsIgnoreCase(username)) {
            throw new UnknownAccountException("用户名不正确");
        }
        if (!"123456".equalsIgnoreCase(password)) {
            throw new IncorrectCredentialsException("密码不正确");
        }
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
