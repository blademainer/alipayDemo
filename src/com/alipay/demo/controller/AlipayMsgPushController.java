/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alipay.demo.bean.msg.AlipayArticleItem;
import com.alipay.demo.bean.msg.AlipayArticleMsg;
import com.alipay.demo.bean.msg.MsgConstants;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.bean.to.ToAlipayMsgPushModelRequst;
import com.alipay.demo.bean.to.ToProcessContext;
import com.alipay.demo.config.SystemConfig;
import com.alipay.demo.process.ServiceEngine;
import com.alipay.demo.tools.URLTool;

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
    @RequestMapping(method = RequestMethod.GET, value = "single.do")
    public String handlerInput(HttpServletRequest httpServletRequest) {
        
        
      
        
        return "msginput";
    }
    
    
 
    /**
     * �ύ������Ϣ
     * 
     * @param httpServletRequest
     */
    @RequestMapping(method = RequestMethod.POST, value = "push.do")
    public ModelAndView handlerPush(HttpServletRequest httpServletRequest) {
        
        String userId = httpServletRequest.getParameter("userId");

        //TODO ����һ����Ϣ
        AlipayArticleMsg alipayArticleMsg = new AlipayArticleMsg();
        alipayArticleMsg.setAppId(SystemConfig.getPublicId());
        alipayArticleMsg.setCreateTime(new Date());
        alipayArticleMsg.setMsgType(MsgConstants.IMGTXT_MSG_TYPE);
        alipayArticleMsg.setToUserId(userId);

        AlipayArticleItem item = new AlipayArticleItem();
        item.setTitle("������Ϣ����");
        item.setUrl(URLTool.builderURL(SystemConfig.getHostUrl() + "/msgDetail.do", null));
        
        alipayArticleMsg.addItem(item);

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

        if (toAlipayModelResp.isSuccess()) {
            modelAndView.setViewName("msgPushSuccess");
        } else {
            modelAndView.setViewName("msgPushFail");
            modelAndView.addObject("errorMsg", toAlipayModelResp.getResultMsg());
            modelAndView.addObject("errorCode", toAlipayModelResp.getResultCode());
        }

        return modelAndView;

    }
}
