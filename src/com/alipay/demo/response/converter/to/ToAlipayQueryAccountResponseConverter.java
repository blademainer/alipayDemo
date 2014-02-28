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
 * @version $Id: ToAlipayQueryAccountResponseConverter.java, v 0.1 2014-2-21 下午6:02:17 jiehua Exp $
 */
public class ToAlipayQueryAccountResponseConverter extends ToAlipayResponseConverter {

    /**
     * 操作名称
     */
    private static final String OPERATION_NAME = "【查询外部户API响应转换器】";

    /**
     * 日志管理
     */
    private static final Logger logger         = Logger
                                                   .getLogger(ToAlipayQueryAccountResponseConverter.class);

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

            AlipayMobilePublicAccountQueryResponse query = (AlipayMobilePublicAccountQueryResponse) srcObj;

            ToAlipayQueryAccountModelResponse accountModelResponse = new ToAlipayQueryAccountModelResponse(
                ResultEnum.SUCESS.getResultCode(), ResultEnum.SUCESS.getResultMsg());
            accountModelResponse.setBindAccountList(query.getPublicBindAccounts());

            return accountModelResponse;
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
