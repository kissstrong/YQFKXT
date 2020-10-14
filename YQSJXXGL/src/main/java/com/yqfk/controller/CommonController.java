package com.yqfk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @author cyz
 * @date 2020-10-14 9:38
 */
@Controller
public class CommonController {
    private final String XTSZ_URL="http://localhost:80";
    /**
     * 错误页面返回登录页面
     * @param response
     * @throws Exception
     */
    @RequestMapping("/BackToLogin")
    public void BackToLogin(HttpServletResponse response)throws Exception{
        response.sendRedirect(XTSZ_URL);
    }

    /**
     * 管理员返回页面
     * @return
     */
    @RequestMapping("/admin/return")
    public String AdminReturn(){
        return "redirect:/admin";
    }

    /**
     * 普通用户返回页面
     * @return
     */
    @RequestMapping("/user/return")
    public String userReturn(){
       return "redirect:/";
    }
}
