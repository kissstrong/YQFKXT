package com.yqfk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cyz
 * @date 2020-10-12 14:34
 */
@Controller
public class MainUserController {
    @Resource
    private RestTemplate restTemplate;
    private final String YQSJXXGL_URL="http://localhost:8005";
    private final String YYCPGL_URL="http://localhost:8006";
    private final String GLYDL_URL="http://localhost:8002";

    /**
     * 普通用户跳转到疫情数据信息管理系统
     * @param response
     * @throws Exception
     */
    @RequestMapping("/index")
    public void index(HttpServletResponse response)throws Exception{
        response.sendRedirect(YQSJXXGL_URL);
    }

}
