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
 * @version $Id: ExampleController.java, v 0.1 2014-4-2 ����10:57:19 jiehua Exp $
 */
public class ExampleController {

    /**
     * ���������ؽ��մ���
     * 
     * @param httpServletRequest
     * @throws Exception 
     */
    @RequestMapping(value = "gateway.do")
    public void doProcess(HttpServletRequest httpServletRequest, HttpServletResponse response)
                                                                                              throws Exception {

        // ֧����RSA��Կ
        String alipayPublicKey = "xxxx";
        // Ӧ��RSA˽Կ
        String appPrivateKey = "yyy";
        // Ӧ��RSA��Կ
        String appPublicKey = "xxyy";

        // 1.��֧����post�����в���ת������ǩ��������
        Map<String, String> params = new HashMap<String, String>();
        for (Object key : httpServletRequest.getParameterMap().keySet()) {
            String keyStr = (String) key;
            params.put(keyStr, httpServletRequest.getParameter(keyStr));
        }

        try {
            // 2.ִ����ǩ����
            // ���������֤����bizContent����֧�������͵�<xml><AppId>xxxx</AppId></xml>
            String bizContent = AlipaySignature.checkSignAndDecrypt(params, alipayPublicKey,
                appPrivateKey, true, false);

            // 3.����bizContent�ֶΣ�����msgType,eventType,actionParam����ҵ����
            // TODO ����&ȷ����������

            // 4.ȷ��������������֤��ͨ�����ߣ��������Ӧ,just for example
            String responseBizContet = "<biz_content>" + appPublicKey
                                       + "</biz_content><success>true</success>";
            String signMsg = AlipaySignature.encryptAndSign(responseBizContet, alipayPublicKey,
                appPrivateKey, "GBK", false, true);

            // 5.��֧����������֤���������Ӧ
            PrintWriter writer = response.getWriter();
            writer.println(signMsg);

        } catch (AlipayApiException e) {

            //TODO  �׳��쳣�����ʶ��ǩʧ�ܣ��̻���������ҵ������쳣�߼�����
        }

    }
}
