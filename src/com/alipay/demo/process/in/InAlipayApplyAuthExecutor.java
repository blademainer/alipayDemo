/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.in;

import java.util.Date;

import org.apache.log4j.Logger;

import com.alipay.demo.bean.HttpRequestKeys;
import com.alipay.demo.bean.LoggerNames;
import com.alipay.demo.bean.factory.AlipayArticleMsgFactory;
import com.alipay.demo.bean.factory.AlipayCacheFactory;
import com.alipay.demo.bean.in.AlipayInArticleMsgResponse;
import com.alipay.demo.bean.in.AlipayInBizContent;
import com.alipay.demo.bean.in.AlipayInModelRequest;
import com.alipay.demo.bean.in.InProcessContext;
import com.alipay.demo.bean.msg.AlipayArticleItem;
import com.alipay.demo.bean.msg.AlipayArticleMsg;
import com.alipay.demo.bean.msg.MsgConstants;
import com.alipay.demo.bean.process.Instruction;
import com.alipay.demo.cache.Cache;
import com.alipay.demo.config.SystemConfig;
import com.alipay.demo.tools.LoggerUtil;
import com.alipay.demo.tools.ServiceTool;
import com.alipay.demo.tools.URLQueryBuilder;
import com.alipay.demo.tools.URLTool;
import com.alipay.demo.tools.UUIDTool;

/**
 * ֧�������ⲿ���������ʵ��
 * 
 * @author jie.hua@alipay.com
 * @version $Id: InAlipayApplyAuthExecutor.java, v 0.1 2014-1-6 ����4:40:12 jie.hua Exp $
 */
public class InAlipayApplyAuthExecutor extends InServiceExecutor {

    /**
     * ��������
     */
    private static final String OPERATION_NAME = "��֧����������˻�����";

    /**
     * ��־
     */
    private static final Logger logger         = Logger.getLogger(LoggerNames.SERVICE_LOGGER);

    /** 
     * @see com.alipay.demo.process.ServiceEngineTemplate#doAction(Instruction)
     */
    @Override
    public void doAction(Instruction instruction) {

        LoggerUtil.info(logger, OPERATION_NAME + ",��ʼִ������󶨴���.");

        InProcessContext inProcessContext = instruction.getInstruction(InProcessContext.class);
        AlipayInModelRequest alipayInRequest = inProcessContext
            .getInstruction(AlipayInModelRequest.class);
        AlipayInBizContent alipayInBizContent = alipayInRequest.getAlipayInBizContent();

        String cacheId = saveUserToCache(alipayInBizContent);

        // 1.�������Ϣ��
        AlipayArticleItem item = new AlipayArticleItem();
        item.setTitle("�󶨿�");
        item.setUrl(builderAuthUrl(alipayInBizContent, cacheId));
        item.setAuthType(MsgConstants.MsgAuthType.LOGIN_AUTH_TYPE);

        // 2.�����������Ϣ
        AlipayArticleMsg toAlipayArticleMsg = new AlipayArticleMsg();
        toAlipayArticleMsg.addItem(item);
        toAlipayArticleMsg.setAppId(alipayInBizContent.getAppId());
        toAlipayArticleMsg.setMsgType(MsgConstants.IMGTXT_MSG_TYPE);
        toAlipayArticleMsg.setCreateTime(new Date());
        toAlipayArticleMsg.setToUserId(alipayInBizContent.getFromUserId());

        // 3.����󶨻ظ���Ӧ
        AlipayInArticleMsgResponse alipayInArticleMsgResponse = AlipayInArticleMsgResponse
            .getSuccessInstance();
        alipayInArticleMsgResponse.setAlipayArticleMsg(toAlipayArticleMsg);
        alipayInArticleMsgResponse
            .setMerchantMsg(AlipayArticleMsgFactory.toXml(toAlipayArticleMsg));

        inProcessContext.setAlipayInResponse(alipayInArticleMsgResponse);

        LoggerUtil.info(logger, OPERATION_NAME + ",ִ������󶨴������.[alipayInArticleMsgResponse="
                                + alipayInArticleMsgResponse + "]");

    }

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return ServiceTool.buildInServiceName(MsgConstants.EVENT_MSG_TYPE,
            MsgConstants.CLICK_EVENT_TYPE, MsgConstants.AUTHENTICATION_ACTIONPARAMS);
    }

    /**
     * ������Ȩurl
     * 
     * @param alipayInBizContent
     * @param cacheId  
     * @return
     */
    private static String builderAuthUrl(AlipayInBizContent alipayInBizContent, String cacheId) {

        // ����������ӵ���Ȩurl���棬ͨ��token��Ч������ǿ��ȫ��
        URLQueryBuilder urlQueryBuilder = URLQueryBuilder.newBuilder().appendQuery(
            HttpRequestKeys.CACHE_KEY, cacheId);

        urlQueryBuilder.appendQuery(HttpRequestKeys.USER_ID, alipayInBizContent.getFromUserId());

        return URLTool.builderURL(SystemConfig.getHostUrl() + "/applyAuth.do",
            urlQueryBuilder.toQueryString());

    }

    /**
     * �����û���Ϣ
     * 
     * @param alipayInBizContent
     * @return
     */
    private String saveUserToCache(AlipayInBizContent alipayInBizContent) {
        // �û���Ϣ�ŵ�����
        Cache cache = AlipayCacheFactory.getCacheInstance();
        String cacheId = UUIDTool.random();
        cache.put(cacheId, alipayInBizContent.getUserInfo());

        LoggerUtil.info(logger, OPERATION_NAME + "�����û���Ϣ[cacheId=" + cacheId + ",userInfo="
                                + alipayInBizContent.getUserInfo() + "]");

        return cacheId;
    }
}
