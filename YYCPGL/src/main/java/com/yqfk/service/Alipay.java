package com.yqfk.service;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.yqfk.pojo.AlipayBean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class Alipay {

    /**
     * 支付接口
     * @param alipayBean
     * @return
     * @throws AlipayApiException
     */

    public String pay(AlipayBean alipayBean) throws AlipayApiException {
        // 1、获得初始化的AlipayClient

        String serverUrl = "https://openapi.alipaydev.com/gateway.do";
        String appId = "2016102500758264";
        String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCJ+QTWp7ZcUxgfvl7kCADLCfkjMFA+fSK9j3bz5j7l5jzY3jMyPothRlA34e2YYqR95pLj2J207ZHf7Avi2Ey9dQhfy8snm7MXfNu2gD+V21Aag0jsXyVkuZWY0c17awpBvwg7redw2CJk8vs7NNhAqWVi6Q5npeTwrELzuL6SWR1ZwOPxfokh5iXtwzwSVi3hsZ3ypEBeK5Lj3pusrWZU4spuvwoMBnkRzN4b3HbGVAoKG0SM0LmBH19Ku7wCHxBywcMDq59fH2JsOT0S4OOVgF9oCHjEkCxocHrPUACWyPwws1ye5Y3s/rrTGliXL0RqWwNsd1mcuMIk3smIuEFRAgMBAAECggEAY98keHj4EQZ5DOlRaMC+SjqS47ziKQmNryd9FHmTB/lMDDNzXahWXfh2sqzQvqCQry3LIDC5n7DkCfGkfPTTP8TKZgVvreEPly3jIMzeugwBhN+JVshcmfeYaQFdOzw1NXghbomoYU+iPe6Ams/axZuY7ysCKVa1TN10rVUKZYYZ1SaDRGG4EggVNlK2V5IqTA8nf3vHEjFWtf8gzdw/yoqiknnIE+lZpIBSG4q/meFgcj5DvmpEUwJcbpitltn7fa/BbzXQhTL/AT4DKw8jALAr77i2/o4ZfyR3PlSPuF0KEREaMAMNg/FUzgFO3bZc2EUNuRtJwsdBaeVZt4pkjQKBgQDEgszTvnaBqgK8QKkjxCZQ5mVjlSHaU2y103Gtj8GkgfDnaK3P0ilqf/hCf6SvADOqksR1IIw03FGfaQ7YTAiMVOGDCMVm/zEbMV+sZMO73didQmpn591YobZCh5gTDj/BdDUkuuexfFZCTTxRhlBb6crRe9yA9smwGudCs0qqkwKBgQCzvaBNrl8kELErxDWxp0uIAjapNDbwDL1x3kGJ6aC41bB4ktonduI8BjyM0ydwdOvm5BbIMCVxEGpDsyF6URBut2LaYHPvxt6qVAH/ib7xw93OLnbK2QMlpNEOKu9i7VeYrSOtFAo4rkqO/IBQeRs/b1KCQlKSrZSap0oe6Qx/CwKBgENQDruFZXCa/N7hQ07WFM3nbdmDrxnrM7TA3hK2yH0CabPK3qbudXNerHqS4KV1az1FkvgQExbUVT1GrmgW+2KefLT23y+dwINxETWrOoTyxA1yP6KiAOcoVZdKfSQh4GLy3HVddJoOXjnN3RiL6qDhX7EMPYcLgiDJxmfJpIzzAoGBAKysT4RRMDWFk69oH+07uuQ+vCRxdRXIJ3ds/alwOGdZYt9ytQGUxGLF2wWvFQSETtzR4tEO7+ley7eeL1tC5XZ31w/T+Y0wkFkxu3my6y137W5WVOkq8ksHu47Q0IlJWg3ix5NO3UL2rcoP6XVl4zddyvY4oPsopsqsTBjF6qthAoGBAJKI2g00wnYiMkEYwlSb/Q4xf0YE00c43xbC2OfDBWwZiLXYeovQkeb0tUkMgo9aXjHzNsXg/ATn8OzEvWCdhQQHVghMA4M/UfoH1YPinOX4N9L4mjn5vKr3H7QZCdRfOebooKsYYeFaNDJZmru4vPCFk3xjIdwz1XCVbO6SG2Mx";
        String format = "json";
        String charset = "utf-8";
        String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvwPiq/1RzVGcNZc7ziThsTh7bJuJqKI45AdSOe3CJOgd3nlnr84D++b1AhBrZPT8ToLaUQxLQKjqkNmqtM2Dr1xaFYJ4dqr5I9EnDc3lC7SBKFOWUP3N5edTe9zzLjnQrt2MfKuAwLLdfS8TezBS72m2NrDrS0fEbFO6zrApgcR9m7os4r079Gt7SHBR2lbZH34uGccy8t77qvsCBi4WxQ7H04aYWveq4OK833xeVkdxxbxHncPhz1SE6Prz7xzhAnLfac6WtmHjlLjKe83OY4ekRyS1qqzhvNvzGdBugLoQux0c8OhuSYnWu6Gf/VixCnvI2qmOwYzOaNRM/vwr/wIDAQAB";
        String signType = "RSA2";
        //支付成功发下面的请求
        String returnUrl = "http://localhost:8006/addOrder";

        String notifyUrl = "http://localhost:8006/404.html";
        AlipayClient alipayClient = new DefaultAlipayClient(serverUrl, appId, privateKey, format, charset, alipayPublicKey, signType);
        // 2、设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        // 页面跳转同步通知页面路径
        alipayRequest.setReturnUrl(returnUrl);
        // 服务器异步通知页面路径
        alipayRequest.setNotifyUrl(notifyUrl);
        //账户订单号
        String out_trade_no = new Date().getTime()+ UUID.randomUUID().toString();
        alipayBean.setOut_trade_no(out_trade_no);
        // 封装参数
        alipayRequest.setBizContent(JSON.toJSONString(alipayBean));
        System.out.println(JSON.toJSONString(alipayBean));
        // 3、请求支付宝进行付款，并获取支付结果
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        // 返回付款信息
        return result;
    }
}
