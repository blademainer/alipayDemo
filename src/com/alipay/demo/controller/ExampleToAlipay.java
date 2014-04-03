/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayMobilePublicMessagePushRequest;
import com.alipay.api.response.AlipayMobilePublicMessagePushResponse;

/**
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ExampleToAlipay.java, v 0.1 2014-4-2 下午2:12:07 jiehua Exp $
 */
public class ExampleToAlipay {

    public void pushMsgToAlipay() {

        // 支付宝对外网关地址 
        String alipayGateWay = "https://openapi.alipay.com";
        // 应用id 
        String appId = "2014xxxxxxxx";
        // 应用RSA私钥 
        String merchantPrivateKey = "yyyyyy";

        // 1.创建代理类实例，建议采用单一实例模式
        // 此处just for demo example
        AlipayClient ALIPAY_CLIENT = new DefaultAlipayClient(alipayGateWay, appId,
            merchantPrivateKey);

        // 2.创建消息发送请求实例
        AlipayMobilePublicMessagePushRequest pushRequest = new AlipayMobilePublicMessagePushRequest();
        String msgContent = "<Xml>参考消息样例</Xml>";
        pushRequest.setBizContent(msgContent);

        try {

            // 3.通过代理类请求支付宝(已包含加签等操作)
            AlipayMobilePublicMessagePushResponse alipayResponse = ALIPAY_CLIENT
                .execute(pushRequest);

            // TODO 开发者根据alipayResponse 内isSuccess等信息处理业务逻辑

        } catch (AlipayApiException e) {

            // TODO 请求支付宝异常，开发者根据自身业务添加处理逻辑
        }

    }

}
