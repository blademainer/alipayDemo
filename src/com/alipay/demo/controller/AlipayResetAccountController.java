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

import com.alipay.demo.bean.to.AlipayThirdAccountInfo;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.bean.to.ToAlipayResetAccountModelRequest;
import com.alipay.demo.bean.to.ToAlipayResetAccountModelResponse;
import com.alipay.demo.bean.to.ToProcessContext;
import com.alipay.demo.config.SystemConfig;
import com.alipay.demo.process.ServiceEngine;

/**
 * 重置外部户控制器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayResetAccountController.java, v 0.1 2014-2-21 下午4:36:04 jiehua Exp $
 */
@Controller
public class AlipayResetAccountController {

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

    private static final String ARGID      = "agrId";

    /**
     * 对外执行引擎
     */
    @Autowired
    @Qualifier("toServiceEngine")
    private ServiceEngine       toServiceEngine;

    /**
     * 查询
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "updateAuth.do")
    public String doGet() {

        return "updateAuth";
    }

    /**
     * 重置
     * 
     * @param request
     * @param model
     */
    @RequestMapping(method = RequestMethod.POST, value = "updateAuth.do")
    public String doReset(HttpServletRequest httpServletRequest, Model model) {

        String thirdId = httpServletRequest.getParameter(CTHIRDID);
        String displayName = httpServletRequest.getParameter(CNO);
        String realName = httpServletRequest.getParameter(CNAME);
        String userId = httpServletRequest.getParameter(CUSERID);
        String agrementId = httpServletRequest.getParameter(ARGID);

        AlipayThirdAccountInfo accountInfo = new AlipayThirdAccountInfo();
        accountInfo.setAppId(SystemConfig.getPublicId());
        accountInfo.setBindAccountNo(thirdId);
        accountInfo.setDisplayName(displayName);
        accountInfo.setRealName(realName);
        accountInfo.setFromUserId(userId);
        accountInfo.setAgreementId(agrementId);

        if (!validateInfo(accountInfo)) {

            model.addAttribute(RESULT, Boolean.FALSE.booleanValue());

            model.addAttribute(RESULT_MSG, "输入框不能存在空值");

            return "updateAuth";

        }

        ToAlipayResetAccountModelRequest modelRequest = new ToAlipayResetAccountModelRequest();
        modelRequest.setAlipayAddAccountInfo(accountInfo);

        ToProcessContext toProcessContext = ToProcessContext.getInstance().build(modelRequest);

        toServiceEngine.serviceProcess(toProcessContext);

        ToAlipayModelResponse modelResp = toProcessContext
            .getInstruction(ToAlipayModelResponse.class);

        model.addAttribute(RESULT, modelResp.isSuccess());
        model.addAttribute(RESULT_MSG, modelResp.getResultMsg());

        if (modelResp.isSuccess()) {

            ToAlipayResetAccountModelResponse resetResp = (ToAlipayResetAccountModelResponse) modelResp;
            model.addAttribute(ARGID, resetResp.getAgreementId());
            model.addAttribute(CTHIRDID, thirdId);
            model.addAttribute(CNO, displayName);
            model.addAttribute(CNAME, realName);
            model.addAttribute(CUSERID, userId);
        }

        return "updateAuth";

    }

    /**
     * 
     * 
     * @param info
     * @return
     */
    private boolean validateInfo(AlipayThirdAccountInfo info) {

        if (StringUtils.isBlank(info.getAppId()) || StringUtils.isBlank(info.getBindAccountNo())
            || StringUtils.isBlank(info.getDisplayName())
            || StringUtils.isBlank(info.getFromUserId()) || StringUtils.isBlank(info.getRealName())) {

            return false;
        }

        return true;

    }

}
