/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter.to;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alipay.api.AlipayResponse;
import com.alipay.api.response.AlipayMobilePublicAccountQueryResponse;
import com.alipay.demo.bean.ResultEnum;
import com.alipay.demo.bean.factory.AlipayErrorCodeFactory;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.bean.to.ToAlipayQueryAccountModelResponse;
import com.alipay.demo.config.SystemConfig;
import com.alipay.demo.tools.LoggerUtil;

/**
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayQueryAccountResponseConverter.java, v 0.1 2014-2-21 ����6:02:17 jiehua Exp $
 */
public class ToAlipayQueryAccountResponseConverter extends ToAlipayResponseConverter {

    /**
     * ��������
     */
    private static final String OPERATION_NAME = "����ѯ�ⲿ��API��Ӧת������";

    /**
     * ��־����
     */
    private static final Logger logger         = Logger
                                                   .getLogger(ToAlipayQueryAccountResponseConverter.class);

    /** 
     * @see com.alipay.demo.response.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ToAlipayModelResponse convert(AlipayResponse srcObj) {

        // 1.�쳣���
        if (srcObj == null) {

            ToAlipayModelResponse accountModelResponse = new ToAlipayModelResponse(
                ResultEnum.SYSTEM_ERROR.getResultCode(), ResultEnum.SYSTEM_ERROR.getResultMsg());
            accountModelResponse.setSuccess(false);

            return accountModelResponse;

        } else if (srcObj.isSuccess()
                   && StringUtils.equalsIgnoreCase(SystemConfig.getAlipaySuccessCode(),
                       srcObj.getErrorCode())) {
            // 2.�ɹ�����£���װЭ��ŷ���

            LoggerUtil.info(logger, OPERATION_NAME + ",����ɹ�.[resultCode=" + srcObj.getErrorCode()
                                    + "]");

            AlipayMobilePublicAccountQueryResponse query = (AlipayMobilePublicAccountQueryResponse) srcObj;

            ToAlipayQueryAccountModelResponse accountModelResponse = new ToAlipayQueryAccountModelResponse(
                ResultEnum.SUCESS.getResultCode(), ResultEnum.SUCESS.getResultMsg());
            accountModelResponse.setBindAccountList(query.getPublicBindAccounts());

            return accountModelResponse;
        } else {

            // 3.ʧ������£�ת�������
            ResultEnum modelResult = AlipayErrorCodeFactory.convertFromAlipayResponse(
                srcObj.getErrorCode(), srcObj.getMsg());

            ToAlipayModelResponse accountModelResponse = new ToAlipayModelResponse(
                modelResult.getResultCode(), modelResult.getResultMsg());
            accountModelResponse.setSuccess(false);

            return accountModelResponse;
        }
    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayResponseConverter#getSrcClass()
     */
    @Override
    public Class<? extends AlipayResponse> getSrcClass() {
        return AlipayMobilePublicAccountQueryResponse.class;
    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayResponseConverter#getTargetClass()
     */
    @Override
    public Class<? extends ToAlipayModelResponse> getTargetClass() {
        return ToAlipayQueryAccountModelResponse.class;
    }

}
