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
 * @version $Id: ExampleToAlipay.java, v 0.1 2014-4-2 ����2:12:07 jiehua Exp $
 */
public class ExampleToAlipay {

    public void pushMsgToAlipay() {

        // ֧�����������ص�ַ 
        String alipayGateWay = "https://openapi.alipay.com";
        // Ӧ��id 
        String appId = "2014xxxxxxxx";
        // Ӧ��RSA˽Կ 
        String merchantPrivateKey = "yyyyyy";

        // 1.����������ʵ����������õ�һʵ��ģʽ
        // �˴�just for demo example
        AlipayClient ALIPAY_CLIENT = new DefaultAlipayClient(alipayGateWay, appId,
            merchantPrivateKey);

        // 2.������Ϣ��������ʵ��
        AlipayMobilePublicMessagePushRequest pushRequest = new AlipayMobilePublicMessagePushRequest();
        String msgContent = "<Xml>�ο���Ϣ����</Xml>";
        pushRequest.setBizContent(msgContent);

        try {

            // 3.ͨ������������֧����(�Ѱ�����ǩ�Ȳ���)
            AlipayMobilePublicMessagePushResponse alipayResponse = ALIPAY_CLIENT
                .execute(pushRequest);

            // TODO �����߸���alipayResponse ��isSuccess����Ϣ����ҵ���߼�

        } catch (AlipayApiException e) {

            // TODO ����֧�����쳣�������߸�������ҵ����Ӵ����߼�
        }

    }

}
