package com.haha.casmember.config;


import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 本地用户信息过滤器
 *
 * @author wjx
 * @Date 2019/3/5 16:02
 */
public class LocalUserInfoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request_ = (HttpServletRequest) request;
        String loginName = CASUtil.getAccountNameFromCas(request_);
        if (!StringUtils.isEmpty(loginName)) {
            request_.getSession().setAttribute("loginName", loginName);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}