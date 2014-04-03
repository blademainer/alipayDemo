/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;

/**
 * just for document example
 * @author jie.hua@alipay.com
 * @version $Id: ExampleController.java, v 0.1 2014-4-2 上午10:57:19 jiehua Exp $
 */
public class ExampleController {

    /**
     * 开发者网关接收处理
     * 
     * @param httpServletRequest
     * @throws Exception 
     */
    @RequestMapping(value = "gateway.do")
    public void doProcess(HttpServletRequest httpServletRequest, HttpServletResponse response)
                                                                                              throws Exception {

        // 支付宝RSA公钥
        String alipayPublicKey = "xxxx";
        // 应用RSA私钥
        String appPrivateKey = "yyy";
        // 应用RSA公钥
        String appPublicKey = "xxyy";

        // 1.将支付宝post的所有参数转换成验签参数集合
        Map<String, String> params = new HashMap<String, String>();
        for (Object key : httpServletRequest.getParameterMap().keySet()) {
            String keyStr = (String) key;
            params.put(keyStr, httpServletRequest.getParameter(keyStr));
        }

        try {
            // 2.执行验签操作
            // 针对网关验证请求，bizContent就是支付宝发送的<xml><AppId>xxxx</AppId></xml>
            String bizContent = AlipaySignature.checkSignAndDecrypt(params, alipayPublicKey,
                appPrivateKey, true, false);

            // 3.解析bizContent字段，根据msgType,eventType,actionParam进行业务处理
            // TODO 解析&确认请求类型

            // 4.确认请求是网关验证开通开发者，则进行响应,just for example
            String responseBizContet = "<biz_content>" + appPublicKey
                                       + "</biz_content><success>true</success>";
            String signMsg = AlipaySignature.encryptAndSign(responseBizContet, alipayPublicKey,
                appPrivateKey, "GBK", false, true);

            // 5.对支付宝网关验证请求进行响应
            PrintWriter writer = response.getWriter();
            writer.println(signMsg);

        } catch (AlipayApiException e) {

            //TODO  抛出异常，则标识验签失败，商户根据自行业务进行异常逻辑处理
        }

    }
}
