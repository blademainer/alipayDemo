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
import com.alipay.demo.bean.to.ToAlipayResetAccountModelResponse;
import com.alipay.demo.bean.to.ToProcessContext;
import com.alipay.demo.config.SystemConfig;
import com.alipay.demo.process.ServiceEngine;

/**
 * 删除外部户
 * @author jie.hua@alipay.com
 * @version $Id: AlipayDeleteAccountController.java, v 0.1 2014-2-22 下午5:21:31 jiehua Exp $
 */
@Controller
public class AlipayDeleteAccountController {

    /**  */
    private static final String RESULT_MSG = "resultMsg";

    /**  */
    private static final String RESULT     = "result";

    /**  */
    private static final String CUSERID    = "cuserid";

    /**  */
    private static final String CNO        = "cno";

    /**  */
    private static final String CNAME      = "cname";

    /***/
    private static final String CTHIRDID   = "cthirdid";

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
        String displayName = httpServletRequest.getParameter(CNO);
        String realName = httpServletRequest.getParameter(CNAME);
        String userId = httpServletRequest.getParameter(CUSERID);

        AlipayThirdAccountInfo accountInfo = new AlipayThirdAccountInfo();
        accountInfo.setAppId(SystemConfig.getPublicId());
        accountInfo.setBindAccountNo(thirdId);
        accountInfo.setDisplayName(displayName);
        accountInfo.setRealName(realName);
        accountInfo.setFromUserId(userId);

        ToAlipayDeleteAccountModelRequest modelRequest = new ToAlipayDeleteAccountModelRequest();
        modelRequest.setAlipayThirdAccountInfo(accountInfo);

        ToProcessContext toProcessContext = ToProcessContext.getInstance().build(modelRequest);

        toServiceEngine.serviceProcess(toProcessContext);

        ToAlipayModelResponse modelResp = toProcessContext
            .getInstruction(ToAlipayModelResponse.class);

        model.addAttribute(RESULT, modelResp.isSuccess());
        model.addAttribute(RESULT_MSG, modelResp.getResultMsg());

        if (modelResp.isSuccess()) {

            ToAlipayResetAccountModelResponse resetResp = (ToAlipayResetAccountModelResponse) modelResp;
            model.addAttribute("agreementId", resetResp.getAgreementId());
            model.addAttribute(CTHIRDID, thirdId);
            model.addAttribute(CNO, displayName);
            model.addAttribute(CNAME, realName);
            model.addAttribute(CUSERID, userId);
        }

        return "deleteAuth";

    }

}
