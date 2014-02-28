/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alipay.demo.bean.factory.AlipayArticleMsgFactory;
import com.alipay.demo.bean.msg.AlipayArticleMsg;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.bean.to.ToAlipayMsgPushModelRequst;
import com.alipay.demo.bean.to.ToProcessContext;
import com.alipay.demo.process.ServiceEngine;

/**
 * 消息发送控制器
 * <pre>
 *   这里只是个样例，真实情况下的消息发送应该是有其他业务触发的，例如银行卡动账、手机话费提醒等
 *   只需要参照本controller内handlerPush即可
 * </pre>
 * @author jie.hua@alipay.com
 * @version $Id: AlipayMsgPushController.java, v 0.1 2014-1-12 下午4:40:31 jie.hua Exp $
 */
@Controller
public class AlipayMsgPushController {

    /**
     * 商户->支付宝服务执行引擎
     */
    @Autowired
    @Qualifier("toServiceEngine")
    private ServiceEngine toServiceEngine;

    /**
     * 展示消息输入界面
     * 
     * @param httpServletRequest
     */
    @RequestMapping(method = RequestMethod.GET, value = "msginput.do")
    public String handlerInput(HttpServletRequest httpServletRequest) {

        return "msginput";
    }

    /**
     * 提交发送消息
     * 
     * @param httpServletRequest
     */
    @RequestMapping(method = RequestMethod.POST, value = "msginput.do")
    public ModelAndView handlerPush(HttpServletRequest httpServletRequest) {

        String msgContent = httpServletRequest.getParameter("content");

        //根据填入xml转消息
        AlipayArticleMsg alipayArticleMsg = AlipayArticleMsgFactory.fromXml(msgContent);

        // 1.构建请求
        ToAlipayMsgPushModelRequst toAlipayMsgPushModelRequst = ToAlipayMsgPushModelRequst
            .getInstance().build(alipayArticleMsg);

        ToProcessContext toProcessContext = ToProcessContext.getInstance().build(
            toAlipayMsgPushModelRequst);

        // 2.执行服务
        toServiceEngine.serviceProcess(toProcessContext);

        // 3.执行结果
        ToAlipayModelResponse toAlipayModelResp = toProcessContext
            .getInstruction(ToAlipayModelResponse.class);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("result", toAlipayModelResp.isSuccess());
        modelAndView.addObject("msgContent", msgContent);

        if (toAlipayModelResp.isSuccess()) {
            modelAndView.setViewName("msginput");
            modelAndView.addObject("sucessMsg", "消息发送成功!");
        } else {
            modelAndView.setViewName("msginput");
            modelAndView.addObject("errorMsg", toAlipayModelResp.getResultMsg());
            modelAndView.addObject("errorCode", toAlipayModelResp.getResultCode());
        }

        return modelAndView;

    }

}
