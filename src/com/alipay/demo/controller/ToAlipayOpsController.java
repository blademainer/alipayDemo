/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 支付宝提供的商户直接调用功能列表
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayOpsController.java, v 0.1 2014-2-20 上午9:28:41 jiehua Exp $
 */
@Controller
public class ToAlipayOpsController {

    /**
     * 展示所有功能服务
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "merchant.do")
    public String doGet(HttpServletRequest request) {

        System.out.println(request.getRequestURL());
        System.out.println("");
        System.out.println(request.getQueryString());

        return "merchant";
    }

}
