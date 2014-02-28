/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter.to;

import org.apache.commons.lang3.StringUtils;

import com.alipay.api.AlipayResponse;
import com.alipay.api.response.AlipayMobilePublicMenuGetResponse;
import com.alipay.demo.bean.ResultEnum;
import com.alipay.demo.bean.factory.AlipayErrorCodeFactory;
import com.alipay.demo.bean.to.ToAlipayMenuQueryModelResponse;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.config.SystemConfig;

/**
 * 菜单查询结果转换
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayMenuQueryResponseConverter.java, v 0.1 2014-2-20 下午6:01:24 jiehua Exp $
 */
public class ToAlipayMenuQueryResponseConverter extends ToAlipayResponseConverter {

    /** 
     * @see com.alipay.demo.response.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ToAlipayModelResponse convert(AlipayResponse srcObj) {

        AlipayMobilePublicMenuGetResponse alipayMobilePublicMenuGetResponse = (AlipayMobilePublicMenuGetResponse) srcObj;

        // 1.异常情况
        if (srcObj == null) {

            ToAlipayModelResponse accountModelResponse = new ToAlipayModelResponse(
                ResultEnum.SYSTEM_ERROR.getResultCode(), ResultEnum.SYSTEM_ERROR.getResultMsg());
            accountModelResponse.setSuccess(false);

            return accountModelResponse;

        } else if (srcObj.isSuccess()
                   && StringUtils.equalsIgnoreCase(SystemConfig.getAlipaySuccessCode(),
                       srcObj.getErrorCode())) {
            // 2.成功情况下，

            ToAlipayMenuQueryModelResponse accountModelResponse = new ToAlipayMenuQueryModelResponse(
                ResultEnum.SUCESS.getResultCode(), ResultEnum.SUCESS.getResultMsg());

            accountModelResponse.setMenuContent(alipayMobilePublicMenuGetResponse.getMenuContent());

            return accountModelResponse;
        } else {

            // 3.失败情况下，转换结果码
            ResultEnum modelResult = AlipayErrorCodeFactory.convertFromAlipayResponse(
                alipayMobilePublicMenuGetResponse.getErrorCode(),
                alipayMobilePublicMenuGetResponse.getMsg());

            ToAlipayMenuQueryModelResponse modelResponse = new ToAlipayMenuQueryModelResponse(
                modelResult.getResultCode(), modelResult.getResultMsg());
            modelResponse.setMenuContent(alipayMobilePublicMenuGetResponse.getMenuContent());

            return modelResponse;
        }
    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayResponseConverter#getSrcClass()
     */
    @Override
    public Class<? extends AlipayResponse> getSrcClass() {
        return AlipayMobilePublicMenuGetResponse.class;
    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayResponseConverter#getTargetClass()
     */
    @Override
    public Class<? extends ToAlipayModelResponse> getTargetClass() {
        return ToAlipayMenuQueryModelResponse.class;
    }

}
