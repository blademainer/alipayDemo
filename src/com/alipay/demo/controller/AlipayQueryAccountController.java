/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alipay.api.domain.PublicBindAccount;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.bean.to.ToAlipayQueryAccountInfo;
import com.alipay.demo.bean.to.ToAlipayQueryAccountModelRequest;
import com.alipay.demo.bean.to.ToAlipayQueryAccountModelResponse;
import com.alipay.demo.bean.to.ToProcessContext;
import com.alipay.demo.config.SystemConfig;
import com.alipay.demo.process.ServiceEngine;

/**
 * 查询外部户
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayQueryAccountController.java, v 0.1 2014-2-21 下午5:38:30 jiehua Exp $
 */
@Controller
public class AlipayQueryAccountController {

    /**  */
    private static final String ACCOUNT_Q         = "accountQ";
    /**  */
    private static final String BIND_ACCOUNT_LIST = "bindAccountList";
    /**  */
    private static final String HAS_NOT_BINDS     = "hasNotBinds";

    /**  */
    private static final String PUBLIC_ID         = "publicId";
    /**  */
    private static final String USER_ID           = "userId";
    /**  */
    private static final String RESULT_MSG        = "resultMsg";
    /**  */
    private static final String RESULT            = "result";
    /**
     * 商户->支付宝服务执行引擎
     */
    @Autowired
    @Qualifier("toServiceEngine")
    private ServiceEngine       toServiceEngine;

    /**
     * 查询外部户
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "accountQuery.do")
    public String doGet() {

        return ACCOUNT_Q;
    }

    /**
     * 查询外部户
     * 
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "accountQuery.do")
    public String doQuery(HttpServletRequest request, Model model) {

        String userId = request.getParameter(USER_ID);

        if (StringUtils.isBlank(userId)) {

            model.addAttribute(RESULT, Boolean.FALSE.booleanValue());
            model.addAttribute(RESULT_MSG, "userId不能为空!");

            return ACCOUNT_Q;
        }

        ToAlipayQueryAccountModelRequest modelRequest = buildQueryModelRequest(userId);

        ToProcessContext toProcessContext = ToProcessContext.getInstance().build(modelRequest);

        toServiceEngine.serviceProcess(toProcessContext);

        ToAlipayModelResponse modelResp = toProcessContext
            .getInstruction(ToAlipayModelResponse.class);

        model.addAttribute(RESULT, modelResp.isSuccess());
        model.addAttribute(RESULT_MSG, modelResp.getResultMsg());

        if (modelResp.isSuccess()) {

            List<PublicBindAccount> bindAccountList = ((ToAlipayQueryAccountModelResponse) modelResp)
                .getBindAccountList();
            model.addAttribute(BIND_ACCOUNT_LIST, bindAccountList);

            boolean hasBinds = (bindAccountList == null) ? false : (!bindAccountList.isEmpty());
            model.addAttribute(HAS_NOT_BINDS, !hasBinds);
            model.addAttribute(USER_ID, userId);
            model.addAttribute(PUBLIC_ID, SystemConfig.getPublicId());
        }

        return ACCOUNT_Q;
    }

    /**
     * 
     * @param userId
     * @return
     */
    private ToAlipayQueryAccountModelRequest buildQueryModelRequest(String userId) {
        ToAlipayQueryAccountModelRequest modelRequest = new ToAlipayQueryAccountModelRequest();

        ToAlipayQueryAccountInfo info = new ToAlipayQueryAccountInfo();
        info.setUserId(userId);
        modelRequest.setAccountInfo(info);
        return modelRequest;
    }
}
