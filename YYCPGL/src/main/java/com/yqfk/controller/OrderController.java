package com.yqfk.controller;

import com.alipay.api.AlipayApiException;
import com.yqfk.pojo.AlipayBean;
import com.yqfk.pojo.Order;
import com.yqfk.service.Alipay;
import com.yqfk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OrderController {
    @Autowired
    private Alipay alipay;
    @Autowired
    private OrderService orderService;

    /**
     * 支付宝主页面表单所填写的数据提交到这个请求
     * @param alipayBean
     * @param request
     * @return
     * @throws AlipayApiException
     */
    @RequestMapping("/alipay1")
    @ResponseBody
    public String alipay(AlipayBean alipayBean, HttpServletRequest request) throws AlipayApiException {
        return alipay.pay(alipayBean);
    }

}
