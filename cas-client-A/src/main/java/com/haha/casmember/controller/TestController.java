package com.haha.casmember.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
public class TestController {


    @Value("${server.port}")
    private String serverPort;

    @Value("${casClientLogoutUrl}")
    private String clientLogoutUrl;

    @GetMapping("/")
    public String hello() {
        return "我是VIP：" + serverPort;
    }


    @GetMapping("/logout")
    public void logout(HttpSession session, HttpServletResponse response)throws Exception {
        session.invalidate();//销毁session
        //使用cas退出成功后,跳转页面
        response.sendRedirect(clientLogoutUrl);
    }

}
