package com.yqfk.controller;

import com.yqfk.pojo.Result;
import com.yqfk.pojo.StatusCode;
import com.yqfk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 发送验证码
     */
    @ResponseBody
    @RequestMapping(value = "/sendSms/{mobile}"/*,method = RequestMethod.POST*/)
    public Result sendMsg(@PathVariable String mobile){
        userService.sendMsg(mobile);
        return new Result(true, StatusCode.OK, "发送成功");
    }

    @RequestMapping("/tologin")
    public String tologin(){
        return "index";
    }
    @RequestMapping("/toregister")
    public String toregister(){
        return "register";
    }


}
