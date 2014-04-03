/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alipay.demo.bean.to.AlipayThirdAccountInfo;
import com.alipay.demo.bean.to.ToAlipayDeleteAccountModelRequest;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.bean.to.ToProcessContext;
import com.alipay.demo.config.SystemConfig;
import com.alipay.demo.process.ServiceEngine;

/**
 * ɾ���ⲿ��
 * @author jie.hua@alipay.com
 * @version $Id: AlipayDeleteAccountController.java, v 0.1 2014-2-22 ����5:21:31 jiehua Exp $
 */
@Controller
public class AlipayDeleteAccountController {

    /**  */
    private static final String RESULT_MSG = "resultMsg";

    /**  */
    private static final String RESULT     = "result";

    /***/
    private static final String CTHIRDID   = "cthirdid";

    private static final String ARGID      = "agrId";

    /**  */
    private static final String CUSERID    = "cuserid";

    /**
     * ����ִ������
     */
    @Autowired
    @Qualifier("toServiceEngine")
    private ServiceEngine       toServiceEngine;

    /**
     * 
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "deleteAuth.do")
    public String doGet() {

        return "deleteAuth";
    }

    /**
     * 
     * 
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "deleteAuth.do")
    public String doDelete(HttpServletRequest httpServletRequest, Model model) {

        String thirdId = httpServletRequest.getParameter(CTHIRDID);
        String agreementId = httpServletRequest.getParameter(ARGID);
        String fromUserId = httpServletRequest.getParameter(CUSERID);

        AlipayThirdAccountInfo accountInfo = new AlipayThirdAccountInfo();
        accountInfo.setAppId(SystemConfig.getPublicId());
        accountInfo.setBindAccountNo(thirdId);
        accountInfo.setAgreementId(agreementId);
        accountInfo.setFromUserId(fromUserId);

        ToAlipayDeleteAccountModelRequest modelRequest = new ToAlipayDeleteAccountModelRequest();
        modelRequest.setAlipayThirdAccountInfo(accountInfo);

        ToProcessContext toProcessContext = ToProcessContext.getInstance().build(modelRequest);

        toServiceEngine.serviceProcess(toProcessContext);

        ToAlipayModelResponse modelResp = toProcessContext
            .getInstruction(ToAlipayModelResponse.class);

        model.addAttribute(RESULT, modelResp.isSuccess());
        model.addAttribute(RESULT_MSG, modelResp.getResultMsg());

        return "deleteAuth";

    }
}
