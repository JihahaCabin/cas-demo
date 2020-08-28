package com.haha.casmember.config;


import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.validation.Assertion;
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
        String loginName = getAccountNameFromCas(request_);
        if (!StringUtils.isEmpty(loginName)) {
            request_.getSession().setAttribute("loginName", loginName);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    /**
     * 从cas中获取用户名
     *
     * @param request
     * @return
     */
    private static String getAccountNameFromCas(HttpServletRequest request) {
        Assertion assertion = (Assertion) request.getSession().getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION);
        if (assertion != null) {
            AttributePrincipal principal = assertion.getPrincipal();
            return principal.getName();
        } else return null;
    }
}













