/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alipay.demo.bean.HttpRequestKeys;
import com.alipay.demo.bean.LoggerNames;
import com.alipay.demo.bean.factory.AlipayCacheFactory;
import com.alipay.demo.bean.in.AlipayInUserInfo;
import com.alipay.demo.bean.msg.AlipayArticleItem;
import com.alipay.demo.bean.msg.AlipayArticleMsg;
import com.alipay.demo.bean.msg.MsgConstants;
import com.alipay.demo.bean.to.AlipayThirdAccountInfo;
import com.alipay.demo.bean.to.ToAlipayAddAccountModelReponse;
import com.alipay.demo.bean.to.ToAlipayAddAccountModelRequest;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.bean.to.ToAlipayMsgPushModelRequst;
import com.alipay.demo.bean.to.ToProcessContext;
import com.alipay.demo.config.SystemConfig;
import com.alipay.demo.process.ServiceEngine;
import com.alipay.demo.tools.LoggerUtil;
import com.alipay.demo.tools.URLTool;

/**
 * ���ⲿ�������ַ
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayAuthenticationController.java, v 0.1 2014-1-6 ����11:25:29 jie.hua Exp $
 */
@Controller
public class AlipayAuthController {

    /**  */
    private static final String CNO            = "cno";

    /**  */
    private static final String CNAME          = "cname";

    /***/
    private static final String CTHIRDID       = "cthirdid";

    /**
     * ��־����
     */
    private static final Logger logger         = Logger.getLogger(LoggerNames.WEB_LOGGER);

    /**
     * ��������
     */
    private static final String OPERATION_NAME = "�����˺�Controller��";

    /**
     * ����ִ������
     */
    @Autowired
    @Qualifier("toServiceEngine")
    private ServiceEngine       toServiceEngine;

    /**
     * ���ⲿ������
     * 
     * @param httpServletRequest
     */
    @RequestMapping(method = RequestMethod.GET, value = "applyAuth.do")
    public void doAuthApply(HttpServletRequest httpServletRequest, Model model) {

        // 1.��ȡ������û���Ϣ
        String cacheId = httpServletRequest.getParameter(HttpRequestKeys.CACHE_KEY);
        Object cacheValue = AlipayCacheFactory.getCacheInstance().get(cacheId);

        LoggerUtil.info(logger, OPERATION_NAME + ",�յ��û���������ӡ�[cacheId=" + cacheId + ",cacheValue="
                                + cacheValue + ",queryStr=" + httpServletRequest.getQueryString()
                                + "]");

        // 2.�û���Ϣ���
        if (cacheValue != null) {
            AlipayInUserInfo userInfo = (AlipayInUserInfo) cacheValue;
            model.addAttribute("userName", userInfo.getUser_name());
            model.addAttribute("loginId", userInfo.getLogon_id());
            model.addAttribute("userId", httpServletRequest.getParameter("userId"));

        }

    }

    /**
     * ���ⲿ�����ύ
     * 
     * @param httpServletRequest
     */
    @RequestMapping(method = RequestMethod.POST, value = "commitAuth.do")
    public ModelAndView doAuthCommit(HttpServletRequest httpServletRequest) {

        LoggerUtil.info(logger, OPERATION_NAME + ",�û�ȷ���ύ�󶨱���");

        //������
        if (StringUtils.isBlank(httpServletRequest.getParameter(CNAME))
            || StringUtils.isBlank(httpServletRequest.getParameter(CNO))
            || StringUtils.isBlank(httpServletRequest.getParameter(CTHIRDID))) {

            ModelAndView errorView = new ModelAndView();
            errorView.addObject("errorMsg", "�������Ϊ��!");
            errorView.setViewName("applyAuth");
            return errorView;
        }

        // 1.��������
        ToAlipayAddAccountModelRequest modelRequest = buildModelRequest(httpServletRequest);
        ToProcessContext toProcessContext = ToProcessContext.getInstance().build(modelRequest);

        // 2.ִ��
        toServiceEngine.serviceProcess(toProcessContext);

        // 3.���ݽ�������Ӧҳ��
        ToAlipayModelResponse toAlipayModelResp = toProcessContext
            .getInstruction(ToAlipayModelResponse.class);

        ModelAndView modelAndView = new ModelAndView();

        if (!toAlipayModelResp.isSuccess()) {

            modelAndView.setViewName("authFail");
            modelAndView.addObject("errorMsg", toAlipayModelResp.getResultMsg());
            modelAndView.addObject("errorCode", toAlipayModelResp.getResultCode());

        } else {

            ToAlipayAddAccountModelReponse toAlipayAddAccountModelReponse = (ToAlipayAddAccountModelReponse) toAlipayModelResp;

            modelAndView.addObject("agreementId", toAlipayAddAccountModelReponse.getAgreementId());

            //�󶨳ɹ���ͬ������һ�����ͳɹ���Ϣ
            ToAlipayModelResponse pushMsgResp = pushAddSuccessMsg(httpServletRequest,
                toAlipayAddAccountModelReponse.getAgreementId());
            modelAndView.addObject("pushMsg", pushMsgResp.isSuccess());

            modelAndView.setViewName("authSuccess");

        }
        return modelAndView;
    }

    /**
     * ��������˻��ɹ���Ϣ
     * 
     * @param httpServletRequest
     * @param agreementId
     * @return 
     */
    private ToAlipayModelResponse pushAddSuccessMsg(HttpServletRequest httpServletRequest,
                                                    String agreementId) {

        LoggerUtil
            .info(logger, OPERATION_NAME + ",���û���Ӧ�˻����Ͱ���Ϣ��[agreementId=" + agreementId + "]");

        //TODO ����һ����Ϣ
        AlipayArticleMsg alipayArticleMsg = new AlipayArticleMsg();
        alipayArticleMsg.setAppId(SystemConfig.getPublicId());
        alipayArticleMsg.setCreateTime(new Date());
        alipayArticleMsg.setMsgType(MsgConstants.IMGTXT_MSG_TYPE);
        alipayArticleMsg.setToUserId(httpServletRequest.getParameter("userId"));
        alipayArticleMsg.setAgreementId(agreementId);

        AlipayArticleItem item = new AlipayArticleItem();
        item.setTitle("����˻��ɹ�");
        item.setUrl(URLTool.builderURL(SystemConfig.getHostUrl() + "/msgDetail.do", null));
        item.setImageUrl("https://i.alipayobjects.com/e/201312/1bq4iTRsqz_src.jpg");

        StringBuilder descBuilder = new StringBuilder(100);
        descBuilder.append("��Ա��:");
        descBuilder.append(httpServletRequest.getParameter(CNAME) + "\n");
        descBuilder.append("����:");
        descBuilder.append(httpServletRequest.getParameter(CNO));
        item.setDesc(descBuilder.toString());

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

        LoggerUtil.info(logger, OPERATION_NAME + ",���û���Ӧ�˻����Ͱ���Ϣ��ɡ�[agreementId=" + agreementId
                                + ",result=" + toAlipayModelResp.getResultCode() + "]");

        return toAlipayModelResp;
    }

    /**
     * ����ҵ������
     * 
     * @param httpServletRequest
     * @return
     */
    private ToAlipayAddAccountModelRequest buildModelRequest(HttpServletRequest httpServletRequest) {

        ToAlipayAddAccountModelRequest modelRequest = new ToAlipayAddAccountModelRequest();

        //TODO ���ʵ���û���Ϣ��from db,file or anywhere
        AlipayThirdAccountInfo accountInfo = new AlipayThirdAccountInfo();
        accountInfo.setAppId(SystemConfig.getPublicId());
        accountInfo.setBindAccountNo(httpServletRequest.getParameter(CTHIRDID));
        accountInfo.setDisplayName(httpServletRequest.getParameter(CNO));
        accountInfo.setRealName(httpServletRequest.getParameter(CNAME));
        accountInfo.setFromUserId(httpServletRequest.getParameter("userId"));

        modelRequest.setAlipayAddAccountInfo(accountInfo);

        return modelRequest;

    }

}
