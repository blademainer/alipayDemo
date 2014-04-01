/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter.to;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alipay.api.AlipayResponse;
import com.alipay.api.response.AlipayMobilePublicQrcodeCreateResponse;
import com.alipay.demo.bean.ResultEnum;
import com.alipay.demo.bean.factory.AlipayErrorCodeFactory;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.bean.to.ToAlipayQRCodeCreateModelResponse;
import com.alipay.demo.config.SystemConfig;
import com.alipay.demo.tools.LoggerUtil;

/**
 * ��ά����ת����
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayQRCreateResponseConverter.java, v 0.1 2014-4-1 ����8:21:25 jiehua Exp $
 */
public class ToAlipayQRCreateResponseConverter extends ToAlipayResponseConverter {

    /**
     * ��������
     */
    private static final String OPERATION_NAME = "�����ɶ�ά��ͼƬapi��Ӧת������";

    /**
     * ��־����
     */
    private static final Logger logger         = Logger
                                                   .getLogger(ToAlipayQRCreateResponseConverter.class);

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

            AlipayMobilePublicQrcodeCreateResponse srcResp = (AlipayMobilePublicQrcodeCreateResponse) srcObj;

            ToAlipayQRCodeCreateModelResponse modelResponse = new ToAlipayQRCodeCreateModelResponse(
                ResultEnum.SUCESS.getResultCode(), ResultEnum.SUCESS.getResultMsg());

            modelResponse.setExpiredTime(srcResp.getExpireSecond());
            modelResponse.setImageUrl(srcResp.getCodeImg());

            return modelResponse;

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
        return AlipayMobilePublicQrcodeCreateResponse.class;
    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayResponseConverter#getTargetClass()
     */
    @Override
    public Class<? extends ToAlipayModelResponse> getTargetClass() {
        return ToAlipayQRCodeCreateModelResponse.class;
    }

}
