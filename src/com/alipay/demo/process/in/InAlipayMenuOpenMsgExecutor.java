/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.in;

import java.util.Date;

import org.apache.log4j.Logger;

import com.alipay.demo.bean.LoggerNames;
import com.alipay.demo.bean.factory.AlipayArticleMsgFactory;
import com.alipay.demo.bean.in.AlipayInArticleMsgResponse;
import com.alipay.demo.bean.in.AlipayInBizContent;
import com.alipay.demo.bean.in.AlipayInModelRequest;
import com.alipay.demo.bean.in.InProcessContext;
import com.alipay.demo.bean.msg.AlipayArticleItem;
import com.alipay.demo.bean.msg.AlipayArticleMsg;
import com.alipay.demo.bean.msg.MsgConstants;
import com.alipay.demo.bean.process.Instruction;
import com.alipay.demo.config.SystemConfig;
import com.alipay.demo.tools.LoggerUtil;
import com.alipay.demo.tools.ServiceTool;
import com.alipay.demo.tools.URLTool;

/**
 * �������Ͳ˵���Ӧִ����
 * <pre>
 *    ������Ϣ��ֱ����֧�����ͻ��˴򿪣�������չʾ��Ӧ��Ϣ��
 * </pre>
 * 
 * @author jie.hua@alipay.com
 * @version $Id: InAlipayMenuOpenMsgExecutor.java, v 0.1 2014-2-15 ����4:40:47 jiehua Exp $
 */
public class InAlipayMenuOpenMsgExecutor extends InServiceExecutor {

    /**
     * ��������
     */
    private static final String OPERATION_NAME = "��֧��������˵�����-����Ϣ��";

    /**
     * ��־
     */
    private static final Logger logger         = Logger.getLogger(LoggerNames.SERVICE_LOGGER);

    /** 
     * @see com.alipay.demo.process.ServiceExecutor#doAction(com.alipay.demo.bean.process.Instruction)
     */
    @Override
    public void doAction(Instruction instruction) {
        LoggerUtil.info(logger, OPERATION_NAME + ",��ʼִ�в˵��������.");

        InProcessContext inProcessContext = instruction.getInstruction(InProcessContext.class);
        AlipayInModelRequest alipayInRequest = inProcessContext
            .getInstruction(AlipayInModelRequest.class);
        AlipayInBizContent alipayInBizContent = alipayInRequest.getAlipayInBizContent();

        // 1.�������Ϣ��
        // TODO ֻ��һ�ּ򵥵��ı���Ӧ��ʽ���̻����Ը�������ҵ�����Լ���Ӧ����Ӧ��ʽ
        AlipayArticleItem item = new AlipayArticleItem();
        item.setTitle("�˵���Ӧ-����Ϣ");
        item.setDesc(buildMsgDesc());
        item.setImageUrl("http://pic.alipayobjects.com/e/201311/1PaQ27Go6H_src.jpg");
        item.setUrl(URLTool.builderURL(SystemConfig.getHostUrl() + "/memberLogin.do", null));
        item.setAuthType(MsgConstants.MsgAuthType.LOGIN_AUTH_TYPE);
        item.setActionName("��Ա��¼");

        // 2.�����������Ϣ
        AlipayArticleMsg toAlipayArticleMsg = new AlipayArticleMsg();
        toAlipayArticleMsg.addItem(item);
        toAlipayArticleMsg.setAppId(alipayInBizContent.getAppId());
        toAlipayArticleMsg.setMsgType(MsgConstants.IMGTXT_MSG_TYPE);
        toAlipayArticleMsg.setCreateTime(new Date());
        toAlipayArticleMsg.setToUserId(alipayInBizContent.getFromUserId());
        toAlipayArticleMsg.setShowType(MsgConstants.MsgShowType.OPEN_DIRECT);

        // 3.����󶨻ظ���Ӧ
        AlipayInArticleMsgResponse alipayInArticleMsgResponse = AlipayInArticleMsgResponse
            .getSuccessInstance();
        alipayInArticleMsgResponse.setAlipayArticleMsg(toAlipayArticleMsg);
        alipayInArticleMsgResponse
            .setMerchantMsg(AlipayArticleMsgFactory.toXml(toAlipayArticleMsg));

        inProcessContext.setAlipayInResponse(alipayInArticleMsgResponse);

        LoggerUtil.info(logger, OPERATION_NAME + ",ִ�в˵�����������.[alipayInArticleMsgResponse="
                                + alipayInArticleMsgResponse + "]");

    }

    /**
     * ������Ϣ��Ӧ
     * 
     * @return
     */
    private String buildMsgDesc() {

        StringBuilder msgBuilder = new StringBuilder(100);
        msgBuilder.append("����һ�ֲ˵���Ӧ����").append("\n").append("�̻����Ը��ݲ�ͬ�˵���Ӧ��ͬ����Ϣ\n")
            .append("���ػ�ֱ�Ӵ���Ϣ��");

        return msgBuilder.toString();
    }

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return ServiceTool.buildInServiceName(MsgConstants.EVENT_MSG_TYPE,
            MsgConstants.CLICK_EVENT_TYPE, MsgConstants.MenuKeys.MENU_MSG_OPEN_RESP);
    }

}
