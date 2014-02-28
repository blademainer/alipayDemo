/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter.to;

import com.alibaba.fastjson.JSON;
import com.alipay.api.request.AlipayMobilePublicAccountResetRequest;
import com.alipay.demo.bean.to.ToAlipayModelRequest;
import com.alipay.demo.bean.to.ToAlipayResetAccountModelRequest;
import com.alipay.demo.bean.to.ToAlipayTargetRequest;

/**
 * 重置外部户业务请求转换器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayResetAccountRequestConverter.java, v 0.1 2014-2-21 下午3:13:34 jiehua Exp $
 */
public class ToAlipayResetAccountRequestConverter extends ToAlipayRequestConverter {

    /** 
     * @see com.alipay.demo.response.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ToAlipayTargetRequest convert(ToAlipayModelRequest srcObj) {

        if (srcObj != null) {

            ToAlipayResetAccountModelRequest modelRequest = (ToAlipayResetAccountModelRequest) srcObj;

            AlipayMobilePublicAccountResetRequest resetRequest = new AlipayMobilePublicAccountResetRequest();

            resetRequest.setBizContent(JSON.toJSONString(modelRequest.getAlipayAddAccountInfo()));

            return new ToAlipayTargetRequest(resetRequest);

        }

        return null;
    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayRequestConverter#getSrcClass()
     */
    @Override
    public Class<? extends ToAlipayModelRequest> getSrcClass() {
        return ToAlipayResetAccountModelRequest.class;
    }

}
