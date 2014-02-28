/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alipay.demo.bean.factory.AlipayInAuthInfoFactory;
import com.alipay.demo.bean.factory.AlipayInTargetReqFactory;
import com.alipay.demo.bean.in.AlipayInAuthInfo;
import com.alipay.demo.bean.in.AlipayInTargetRequest;
import com.alipay.demo.bean.to.AlipaySystemTokenInfo;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.bean.to.ToAlipayTokenModelRequest;
import com.alipay.demo.bean.to.ToAlipayTokenModelResponse;
import com.alipay.demo.bean.to.ToProcessContext;
import com.alipay.demo.process.ServiceEngine;
import com.alipay.demo.tools.LoggerUtil;

/**
 * ��Ա��¼������
 * 
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayMemberLoginController.java, v 0.1 2014-2-15 ����4:51:40 jiehua Exp $
 */
@Controller
public class MemberLoginController {

    /**
     * ��־����
     */
    private static final Logger logger         = Logger.getLogger("weblogger");

    /**
     * �������
     */
    private static final String OPERATION_NAME = "��֧������Ա�������";

    /**
     * �̻�->֧��������ִ������
     */
    @Autowired
    @Qualifier("toServiceEngine")
    private ServiceEngine       toServiceEngine;

    /**
     * ��Ա��¼
     * 
     * @param httpServletRequest
     */
    @RequestMapping(method = RequestMethod.GET, value = "memberLogin.do")
    public void doLogin(HttpServletRequest request, Model model) {

        LoggerUtil.info(logger, OPERATION_NAME + ",����ʼ����...");

        // 1.��װ����
        AlipayInTargetRequest alipayInSrcRequest = AlipayInTargetReqFactory.buildRequest(request);

        AlipayInAuthInfo alipayInAuthInfo = AlipayInAuthInfoFactory.buildInfo(alipayInSrcRequest);

        LoggerUtil.info(logger, OPERATION_NAME + ",���������װ���.[alipayInAuthInfo=" + alipayInAuthInfo
                                + "]");

        model.addAttribute("alipayInAuthInfo", alipayInAuthInfo);

        // 2.����authCode��ȡaccessCode
        AlipaySystemTokenInfo alipaySystemTokenInfo = new AlipaySystemTokenInfo();
        alipaySystemTokenInfo.setAuthCode(alipayInAuthInfo.getAuthCode());

        ToAlipayTokenModelRequest alipayTokenModelRequest = new ToAlipayTokenModelRequest();
        alipayTokenModelRequest.setAlipaySystemTokenInfo(alipaySystemTokenInfo);

        ToProcessContext toProcessContext = ToProcessContext.getInstance().build(
            alipayTokenModelRequest);
        toServiceEngine.serviceProcess(toProcessContext);

        // 3.���accessCode

        ToAlipayModelResponse modelResponse = toProcessContext
            .getInstruction(ToAlipayModelResponse.class);

        model.addAttribute("toAlipayTokenModelResp", modelResponse);

        if (modelResponse.isSuccess()) {
            model.addAttribute("tokenInfo",
                ((ToAlipayTokenModelResponse) modelResponse).getAlipayAccessTokenInfo());
        }

    }

}
