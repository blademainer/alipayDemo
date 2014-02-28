/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.factory;

import org.apache.log4j.Logger;

import com.alipay.demo.bean.ResultEnum;
import com.alipay.demo.tools.LoggerUtil;

/**
 * 
 * ֧���������ת������
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayErrorCodeFactory.java, v 0.1 2014-1-10 ����7:48:01 jie.hua Exp $
 */
public class AlipayErrorCodeFactory {

    /**
     * ��������
     */
    private static final String OPERATION_NAME = "��������ת����";

    /**
     * ��־
     */
    private static final Logger logger         = Logger.getLogger(AlipayErrorCodeFactory.class);

    /**
     *  ֧����errorCode -> ҵ����
     * 
     * @param errorCode
     * @param errorMsg
     * @return
     */
    public static ResultEnum convertFromAlipayResponse(String errorCode, String errorMsg) {

        LoggerUtil.info(logger, OPERATION_NAME + ",֧�������ؽ��[errorCode=" + errorCode + ",errorMsg="
                                + errorMsg + "]");

        // TODO ���ת���߼�

        ResultEnum systemError = ResultEnum.SYSTEM_ERROR;
        systemError.setResultMsg(errorMsg);

        return systemError;

    }

}
