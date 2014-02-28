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
 * 会员登录控制器
 * 
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayMemberLoginController.java, v 0.1 2014-2-15 下午4:51:40 jiehua Exp $
 */
@Controller
public class MemberLoginController {

    /**
     * 日志管理
     */
    private static final Logger logger         = Logger.getLogger("weblogger");

    /**
     * 请求参数
     */
    private static final String OPERATION_NAME = "【支付宝会员免登请求】";

    /**
     * 商户->支付宝服务执行引擎
     */
    @Autowired
    @Qualifier("toServiceEngine")
    private ServiceEngine       toServiceEngine;

    /**
     * 会员登录
     * 
     * @param httpServletRequest
     */
    @RequestMapping(method = RequestMethod.GET, value = "memberLogin.do")
    public void doLogin(HttpServletRequest request, Model model) {

        LoggerUtil.info(logger, OPERATION_NAME + ",请求开始处理...");

        // 1.组装参数
        AlipayInTargetRequest alipayInSrcRequest = AlipayInTargetReqFactory.buildRequest(request);

        AlipayInAuthInfo alipayInAuthInfo = AlipayInAuthInfoFactory.buildInfo(alipayInSrcRequest);

        LoggerUtil.info(logger, OPERATION_NAME + ",请求参数组装完成.[alipayInAuthInfo=" + alipayInAuthInfo
                                + "]");

        model.addAttribute("alipayInAuthInfo", alipayInAuthInfo);

        // 2.根据authCode换取accessCode
        AlipaySystemTokenInfo alipaySystemTokenInfo = new AlipaySystemTokenInfo();
        alipaySystemTokenInfo.setAuthCode(alipayInAuthInfo.getAuthCode());

        ToAlipayTokenModelRequest alipayTokenModelRequest = new ToAlipayTokenModelRequest();
        alipayTokenModelRequest.setAlipaySystemTokenInfo(alipaySystemTokenInfo);

        ToProcessContext toProcessContext = ToProcessContext.getInstance().build(
            alipayTokenModelRequest);
        toServiceEngine.serviceProcess(toProcessContext);

        // 3.检查accessCode

        ToAlipayModelResponse modelResponse = toProcessContext
            .getInstruction(ToAlipayModelResponse.class);

        model.addAttribute("toAlipayTokenModelResp", modelResponse);

        if (modelResponse.isSuccess()) {
            model.addAttribute("tokenInfo",
                ((ToAlipayTokenModelResponse) modelResponse).getAlipayAccessTokenInfo());
        }

    }

}
