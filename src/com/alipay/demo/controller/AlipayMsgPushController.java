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
 * ��Ϣ���Ϳ�����
 * <pre>
 *   ����ֻ�Ǹ���������ʵ����µ���Ϣ����Ӧ����������ҵ�񴥷��ģ��������п����ˡ��ֻ��������ѵ�
 *   ֻ��Ҫ���ձ�controller��handlerPush����
 * </pre>
 * @author jie.hua@alipay.com
 * @version $Id: AlipayMsgPushController.java, v 0.1 2014-1-12 ����4:40:31 jie.hua Exp $
 */
@Controller
public class AlipayMsgPushController {

    /**
     * �̻�->֧��������ִ������
     */
    @Autowired
    @Qualifier("toServiceEngine")
    private ServiceEngine toServiceEngine;

    /**
     * չʾ��Ϣ�������
     * 
     * @param httpServletRequest
     */
    @RequestMapping(method = RequestMethod.GET, value = "msginput.do")
    public String handlerInput(HttpServletRequest httpServletRequest) {

        return "msginput";
    }

    /**
     * �ύ������Ϣ
     * 
     * @param httpServletRequest
     */
    @RequestMapping(method = RequestMethod.POST, value = "msginput.do")
    public ModelAndView handlerPush(HttpServletRequest httpServletRequest) {

        String msgContent = httpServletRequest.getParameter("content");

        //��������xmlת��Ϣ
        AlipayArticleMsg alipayArticleMsg = AlipayArticleMsgFactory.fromXml(msgContent);

        // 1.��������
        ToAlipayMsgPushModelRequst toAlipayMsgPushModelRequst = ToAlipayMsgPushModelRequst
            .getInstance().build(alipayArticleMsg);

        ToProcessContext toProcessContext = ToProcessContext.getInstance().build(
            toAlipayMsgPushModelRequst);

        // 2.ִ�з���
        toServiceEngine.serviceProcess(toProcessContext);

        // 3.ִ�н��
        ToAlipayModelResponse toAlipayModelResp = toProcessContext
            .getInstruction(ToAlipayModelResponse.class);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("result", toAlipayModelResp.isSuccess());
        modelAndView.addObject("msgContent", msgContent);

        if (toAlipayModelResp.isSuccess()) {
            modelAndView.setViewName("msginput");
            modelAndView.addObject("sucessMsg", "��Ϣ���ͳɹ�!");
        } else {
            modelAndView.setViewName("msginput");
            modelAndView.addObject("errorMsg", toAlipayModelResp.getResultMsg());
            modelAndView.addObject("errorCode", toAlipayModelResp.getResultCode());
        }

        return modelAndView;

    }

}
