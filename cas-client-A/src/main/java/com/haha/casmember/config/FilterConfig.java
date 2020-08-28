package com.haha.casmember.config;

import org.jasig.cas.client.session.SingleSignOutFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Value("${cas.server-url-prefix}")
    private String CAS_URL;
    @Value("${cas.client-host-url}")
    private String APP_URL;
    /**
     * 单点登录退出
     */
    @Bean
    public FilterRegistrationBean singleSignOutFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new SingleSignOutFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("casServerUrlPrefix", CAS_URL);
        registrationBean.setName("CAS Single Sign Out Filter");
        registrationBean.setOrder(1);
        return registrationBean;
    }

    /**
     * 从request中获取cas登录信息，根据登录信息获取当前用户，创建本地session
     */
    @Bean
    public FilterRegistrationBean registrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new LocalUserInfoFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("localUserInfoFilter");
        registrationBean.setOrder(2);
        return registrationBean;
    }

}
