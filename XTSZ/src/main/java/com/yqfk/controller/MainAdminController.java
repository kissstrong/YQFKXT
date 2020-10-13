package com.yqfk.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cyz
 * @date 2020-10-12 9:27
 */
@Controller
public class MainAdminController {
    @Resource
    private RestTemplate restTemplate;
    private final String YQSJXXGL_URL="http://localhost:8005";
    private final String YYCPGL_URL="http://localhost:8006";
    private final String GLYDL_URL="http://localhost:8002";

    /**
     * 跳转到管理员主页面
     * @param response
     * @throws Exception
     */
    @RequestMapping("/admin/index")
    public void AdminIndex(HttpServletResponse response)throws Exception{
        response.sendRedirect(GLYDL_URL);
    }

    /**
     * 管理员跳转到疫情数据信息管理系统
     * @param response
     * @throws Exception
     */
    @RequestMapping("/admin/yqsjxxgl")
    public void ToYQSJXXGL(HttpServletResponse response)throws Exception{
        response.sendRedirect(YQSJXXGL_URL);
    }

    /**
     * 管理员跳转到医药厂品管理系统
     * @param response
     * @throws Exception
     */
    @RequestMapping("/admin/yycpgl")
    public void ToYYCPGL(HttpServletResponse response)throws Exception{
        response.sendRedirect(YYCPGL_URL);
    }

}
