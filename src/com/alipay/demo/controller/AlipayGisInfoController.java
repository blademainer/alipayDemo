/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alipay.demo.bean.to.ToAlipayGisGetModelRequest;
import com.alipay.demo.bean.to.ToAlipayGisGetModelResponse;
import com.alipay.demo.bean.to.ToAlipayGisInfo;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.bean.to.ToAlipayQueryAccountInfo;
import com.alipay.demo.bean.to.ToProcessContext;
import com.alipay.demo.config.SystemConfig;
import com.alipay.demo.process.ServiceEngine;

/**
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayGisInfoController.java, v 0.1 2014-2-22 下午5:52:44 jiehua Exp $
 */
@Controller
public class AlipayGisInfoController {

    /**  */
    private static final String PAGE       = "gisInfo";
    /**  */
    private static final String PUBLIC_ID  = "publicId";
    /**  */
    private static final String USER_ID    = "userId";
    /**  */
    private static final String RESULT_MSG = "resultMsg";
    /**  */
    private static final String RESULT     = "result";

    /**
     * 对外执行引擎
     */
    @Autowired
    @Qualifier("toServiceEngine")
    private ServiceEngine       toServiceEngine;

    /**
     * 
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "gisInfo.do")
    public String doGet() {

        return PAGE;
    }

    /**
     * 
     * 
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "gisInfo.do")
    public String doQuery(HttpServletRequest request, Model model) {

        String userId = request.getParameter(USER_ID);

        if (StringUtils.isBlank(userId)) {

            model.addAttribute(RESULT, Boolean.FALSE.booleanValue());
            model.addAttribute(RESULT_MSG, "userId不能为空!");

            return PAGE;
        }

        ToAlipayGisGetModelRequest modelRequest = new ToAlipayGisGetModelRequest();
        ToAlipayQueryAccountInfo accountInfo = new ToAlipayQueryAccountInfo();
        accountInfo.setUserId(userId);
        modelRequest.setAccountInfo(accountInfo);

        ToProcessContext toProcessContext = ToProcessContext.getInstance().build(modelRequest);

        toServiceEngine.serviceProcess(toProcessContext);

        ToAlipayModelResponse modelResp = toProcessContext
            .getInstruction(ToAlipayModelResponse.class);

        model.addAttribute(RESULT, modelResp.isSuccess());
        model.addAttribute(RESULT_MSG, modelResp.getResultMsg());
        model.addAttribute(PUBLIC_ID, SystemConfig.getPublicId());

        if (modelResp.isSuccess()) {

            ToAlipayGisInfo gisInfo = ((ToAlipayGisGetModelResponse) modelResp).getGisInfo();
            model.addAttribute("gisExist", gisInfo != null);
            model.addAttribute("gisInfo", gisInfo);

        }

        return PAGE;

    }

}
