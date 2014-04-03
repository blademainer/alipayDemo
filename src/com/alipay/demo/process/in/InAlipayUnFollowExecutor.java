/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.in;

import org.apache.log4j.Logger;

import com.alipay.demo.bean.LoggerNames;
import com.alipay.demo.bean.in.AlipayInBizContent;
import com.alipay.demo.bean.in.AlipayInModelRequest;
import com.alipay.demo.bean.in.AlipayInModelResponse;
import com.alipay.demo.bean.in.InProcessContext;
import com.alipay.demo.bean.msg.MsgConstants;
import com.alipay.demo.bean.process.Instruction;
import com.alipay.demo.tools.LoggerUtil;
import com.alipay.demo.tools.ServiceTool;

/**
 * ȡ����עִ����
 * 
 * @author jie.hua@alipay.com
 * @version $Id: InAlipayUnFollowExecutor.java, v 0.1 2014-1-17 ����9:07:11 jie.hua Exp $
 */
public class InAlipayUnFollowExecutor extends InServiceExecutor {

    /**
     * ��������
     */
    private static final String OPERATION_NAME = "��֧����ȡ����ע���ں�֪ͨ��";

    /**
     * ��־
     */
    private static final Logger logger         = Logger.getLogger(LoggerNames.SERVICE_LOGGER);

    /** 
     * @see com.alipay.demo.process.ServiceExecutor#doAction(com.alipay.demo.bean.process.Instruction)
     */
    @Override
    public void doAction(Instruction instruction) {

        LoggerUtil.info(logger, OPERATION_NAME + ",��ʼִ��ȡ����ע֪ͨ����.");

        InProcessContext inProcessContext = instruction.getInstruction(InProcessContext.class);
        AlipayInModelRequest alipayInRequest = inProcessContext
            .getInstruction(AlipayInModelRequest.class);
        AlipayInBizContent alipayInBizContent = alipayInRequest.getAlipayInBizContent();

        //TODO ����֧��������������̻�����ɾ��֮ǰ����ı���֧����UID-���ں�ID�Ĺ�ע��ϵ
        // ����ֻ�Ǹ��������������ⲽʡ�ԡ�
        // ֱ�ӹ������Ӧ�������
        inProcessContext.setAlipayInResponse(AlipayInModelResponse.buildSuccessResponse());

        LoggerUtil.info(logger, OPERATION_NAME + ",ִ��ȡ����ע֪ͨ�������.[alipayInBizContent="
                                + alipayInBizContent + "]");
    }

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {

        return ServiceTool.buildInServiceName(MsgConstants.EVENT_MSG_TYPE,
            MsgConstants.UNFOLLOW_EVENT_TYPE, null);
    }

}
