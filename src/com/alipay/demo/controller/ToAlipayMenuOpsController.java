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

import com.alipay.demo.bean.to.ToAlipayMenuCreateModelRequest;
import com.alipay.demo.bean.to.ToAlipayMenuQueryModelRequest;
import com.alipay.demo.bean.to.ToAlipayMenuQueryModelResponse;
import com.alipay.demo.bean.to.ToAlipayMenuUpdateModelRequest;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.bean.to.ToProcessContext;
import com.alipay.demo.config.SystemConfig;
import com.alipay.demo.process.ServiceEngine;

/**
 * 商户请求支付宝菜单操作
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayMenuOpsController.java, v 0.1 2014-2-21 上午8:46:48 jiehua Exp $
 */
@Controller
public class ToAlipayMenuOpsController {

    /**  */
    private static final String RESULT_MSG   = "resultMsg";
    /**  */
    private static final String RESULT       = "result";
    /**  */
    private static final String MENU_OPS     = "menuOps";
    /**  */
    private static final String PUBLIC_ID    = "publicId";
    /**  */
    private static final String MENU_CONTENT = "menuContent";

    /**
     * 商户->支付宝服务执行引擎
     */
    @Autowired
    @Qualifier("toServiceEngine")
    private ServiceEngine       toServiceEngine;

    /**
     * 展示操作界面
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "menuInfo.do")
    public String doGet(Model model) {

        model.addAttribute(PUBLIC_ID, SystemConfig.getPublicId());

        return MENU_OPS;

    }

    /**
     * 查询菜单
     * 
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "menuInfo.do", params = "action=query")
    public String doQuery(Model model) {

        ToAlipayMenuQueryModelRequest modelRequest = new ToAlipayMenuQueryModelRequest();

        ToProcessContext toProcessContext = ToProcessContext.getInstance().build(modelRequest);

        toServiceEngine.serviceProcess(toProcessContext);

        ToAlipayModelResponse modelResponse = toProcessContext
            .getInstruction(ToAlipayModelResponse.class);

        if (modelResponse.isSuccess()) {

            model.addAttribute(MENU_CONTENT,
                ((ToAlipayMenuQueryModelResponse) modelResponse).getMenuContent());

        }

        model.addAttribute(PUBLIC_ID, SystemConfig.getPublicId());
        model.addAttribute(RESULT, modelResponse.isSuccess());
        model.addAttribute(RESULT_MSG, modelResponse.getResultMsg());

        return MENU_OPS;
    }

    /**
     * 更新菜单
     * 
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "menuInfo.do", params = "action=save")
    public String doUpdate(HttpServletRequest request, Model model) {

        ToAlipayMenuUpdateModelRequest modelRequest = new ToAlipayMenuUpdateModelRequest();
        String menuContent = request.getParameter(MENU_CONTENT);
        modelRequest.setMenuContent(menuContent);

        ToProcessContext toProcessContext = ToProcessContext.getInstance().build(modelRequest);

        toServiceEngine.serviceProcess(toProcessContext);

        ToAlipayModelResponse modelResponse = toProcessContext
            .getInstruction(ToAlipayModelResponse.class);

        model.addAttribute(PUBLIC_ID, SystemConfig.getPublicId());
        model.addAttribute(RESULT, modelResponse.isSuccess());
        model.addAttribute(RESULT_MSG, modelResponse.getResultMsg());
        model.addAttribute(MENU_CONTENT, menuContent);

        return MENU_OPS;
    }

    /**
     * 创建菜单
     * 
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "menuInfo.do", params = "action=create")
    public String doCreate(HttpServletRequest request, Model model) {

        ToAlipayMenuCreateModelRequest modelRequest = new ToAlipayMenuCreateModelRequest();
        String menuContent = request.getParameter(MENU_CONTENT);
        modelRequest.setMenuContent(menuContent);

        ToProcessContext toProcessContext = ToProcessContext.getInstance().build(modelRequest);

        toServiceEngine.serviceProcess(toProcessContext);

        ToAlipayModelResponse modelResponse = toProcessContext
            .getInstruction(ToAlipayModelResponse.class);

        model.addAttribute(PUBLIC_ID, SystemConfig.getPublicId());
        model.addAttribute(RESULT, modelResponse.isSuccess());
        model.addAttribute(RESULT_MSG, modelResponse.getResultMsg());
        model.addAttribute(MENU_CONTENT, menuContent);

        return MENU_OPS;
    }

}
