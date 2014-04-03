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
 * ֧����->�̻�ɾ���˻���ִ����
 * 
 * @author jie.hua@alipay.com
 * @version $Id: InAlipayDeleteBindExecutor.java, v 0.1 2014-1-13 ����9:11:26 jie.hua Exp $
 */
public class InAlipayDeleteBindExecutor extends InServiceExecutor {

    /**
     * ��������
     */
    private static final String OPERATION_NAME = "��֧����ɾ�����˻�֪ͨ����";

    /**
     * ��־
     */
    private static final Logger logger         = Logger.getLogger(LoggerNames.SERVICE_LOGGER);

    /** 
     * @see com.alipay.demo.process.ServiceExecutor#doAction(com.alipay.demo.bean.process.Instruction)
     */
    @Override
    public void doAction(Instruction instruction) {

        LoggerUtil.info(logger, OPERATION_NAME + ",��ʼִ��ɾ���󶨴���.");

        InProcessContext inProcessContext = instruction.getInstruction(InProcessContext.class);
        AlipayInModelRequest alipayInRequest = inProcessContext
            .getInstruction(AlipayInModelRequest.class);
        AlipayInBizContent alipayInBizContent = alipayInRequest.getAlipayInBizContent();

        //TODO ����ֻ�Ǽ�demoֱ�ӷ��سɹ���ʵ����Ҫɾ���̻����ذ󶨹�ϵ

        inProcessContext.setAlipayInResponse(AlipayInModelResponse.buildSuccessResponse());

        LoggerUtil.info(logger, OPERATION_NAME + ",ִ��ɾ���󶨴������.[alipayInBizContent="
                                + alipayInBizContent + "]");
    }

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {

        return ServiceTool.buildInServiceName(MsgConstants.EVENT_MSG_TYPE,
            MsgConstants.CLICK_EVENT_TYPE, MsgConstants.DELETE_BIND_ACTIONPARAMS);
    }

}
