package com.eavescat.dispatch.login.sample.filter;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 自定义表单登录验证过滤器
 * Created by wendrewshay on 2019/7/31 17:01
 */
public class LoginAuthenticationFilter extends FormAuthenticationFilter {

    /**
     * Returns <code>true</code> if
     * {@link #isAccessAllowed(ServletRequest, ServletResponse, Object) isAccessAllowed(Request,Response,Object)},
     * otherwise returns the result of
     * {@link #onAccessDenied(ServletRequest, ServletResponse, Object) onAccessDenied(Request,Response,Object)}.
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return <code>true</code> if
     * {@link #isAccessAllowed(ServletRequest, ServletResponse, Object) isAccessAllowed},
     * otherwise returns the result of
     * {@link #onAccessDenied(ServletRequest, ServletResponse) onAccessDenied}.
     * @throws Exception if an error occurs.
     */
    @Override
    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String requestURI = servletRequest.getRequestURI();
        // 此处对访问路径进行了预处理，以防止不同用户对应的访问路径与权限互相影响
        if (requestURI.startsWith("/user")) {
            super.setLoginUrl("/user/login");
            super.setSuccessUrl("/user/index");
        } else {
            super.setLoginUrl("/admin/login");
            super.setSuccessUrl("/admin/index");
        }
        return super.onPreHandle(request, response, mappedValue);
    }
}
