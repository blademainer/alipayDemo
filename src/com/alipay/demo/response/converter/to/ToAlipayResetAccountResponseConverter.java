/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter.to;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alipay.api.AlipayResponse;
import com.alipay.api.response.AlipayMobilePublicAccountResetResponse;
import com.alipay.demo.bean.ResultEnum;
import com.alipay.demo.bean.factory.AlipayErrorCodeFactory;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.bean.to.ToAlipayResetAccountModelResponse;
import com.alipay.demo.config.SystemConfig;
import com.alipay.demo.tools.LoggerUtil;

/**
 * 外部户充值转换器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayResetAccountResponseConverter.java, v 0.1 2014-2-21 下午2:22:56 jiehua Exp $
 */
public class ToAlipayResetAccountResponseConverter extends ToAlipayResponseConverter {

    /**
     * 操作名称
     */
    private static final String OPERATION_NAME = "【重置外部户API响应转换器】";

    /**
     * 日志管理
     */
    private static final Logger logger         = Logger
                                                   .getLogger(ToAlipayResetAccountResponseConverter.class);

    /** 
     * @see com.alipay.demo.response.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ToAlipayModelResponse convert(AlipayResponse srcObj) {

        // 1.异常情况
        if (srcObj == null) {

            ToAlipayModelResponse accountModelResponse = new ToAlipayModelResponse(
                ResultEnum.SYSTEM_ERROR.getResultCode(), ResultEnum.SYSTEM_ERROR.getResultMsg());
            accountModelResponse.setSuccess(false);

            return accountModelResponse;

        } else if (srcObj.isSuccess()
                   && StringUtils.equalsIgnoreCase(SystemConfig.getAlipaySuccessCode(),
                       srcObj.getErrorCode())) {
            // 2.成功情况下，封装协议号返回

            LoggerUtil.info(logger, OPERATION_NAME + ",处理成功.[resultCode=" + srcObj.getErrorCode()
                                    + "]");

            AlipayMobilePublicAccountResetResponse resetResponse = (AlipayMobilePublicAccountResetResponse) srcObj;

            ToAlipayResetAccountModelResponse resetAccountModelResp = new ToAlipayResetAccountModelResponse(
                ResultEnum.SUCESS.getResultCode(), ResultEnum.SUCESS.getResultMsg());

            resetAccountModelResp.setAgreementId(resetResponse.getAgreementId());

            return resetAccountModelResp;
        } else {

            // 3.失败情况下，转换结果码
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
        return AlipayMobilePublicAccountResetResponse.class;
    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayResponseConverter#getTargetClass()
     */
    @Override
    public Class<? extends ToAlipayModelResponse> getTargetClass() {
        return ToAlipayResetAccountModelResponse.class;
    }

}
