/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter.to;

import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.demo.bean.to.AlipaySystemTokenInfo;
import com.alipay.demo.bean.to.ToAlipayModelRequest;
import com.alipay.demo.bean.to.ToAlipayTargetRequest;
import com.alipay.demo.bean.to.ToAlipayTokenModelRequest;

/**
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipaySystemTokenRequestConverter.java, v 0.1 2014-2-20 下午3:48:08 jiehua Exp $
 */
public class ToAlipaySystemTokenRequestConverter extends ToAlipayRequestConverter {

    /** 
     * @see com.alipay.demo.response.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ToAlipayTargetRequest convert(ToAlipayModelRequest srcObj) {

        // 1.原始请求
        ToAlipayTokenModelRequest tokenModelRequest = (ToAlipayTokenModelRequest) srcObj;
        AlipaySystemTokenInfo alipaySystemTokenInfo = tokenModelRequest.getAlipaySystemTokenInfo();

        // 2.转换成支付宝请求
        AlipaySystemOauthTokenRequest tokenRequest = new AlipaySystemOauthTokenRequest();
        tokenRequest.setGrantType(alipaySystemTokenInfo.getGrantType());
        tokenRequest.setCode(alipaySystemTokenInfo.getAuthCode());

        return new ToAlipayTargetRequest(tokenRequest);
    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayRequestConverter#getSrcClass()
     */
    @Override
    public Class<? extends ToAlipayModelRequest> getSrcClass() {
        return ToAlipayTokenModelRequest.class;
    }

}
