/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter.to;

import com.alibaba.fastjson.JSON;
import com.alipay.api.request.AlipayMobilePublicAccountDeleteRequest;
import com.alipay.demo.bean.to.ToAlipayDeleteAccountModelRequest;
import com.alipay.demo.bean.to.ToAlipayModelRequest;
import com.alipay.demo.bean.to.ToAlipayTargetRequest;

/**
 * ÇëÇó×ª»»Æ÷
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayDeleteAccountRequestConverter.java, v 0.1 2014-2-22 ÏÂÎç5:09:32 jiehua Exp $
 */
public class ToAlipayDeleteAccountRequestConverter extends ToAlipayRequestConverter {

    /** 
     * @see com.alipay.demo.response.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ToAlipayTargetRequest convert(ToAlipayModelRequest srcObj) {

        if (srcObj != null) {

            ToAlipayDeleteAccountModelRequest modelRequest = (ToAlipayDeleteAccountModelRequest) srcObj;

            AlipayMobilePublicAccountDeleteRequest deleteRequest = new AlipayMobilePublicAccountDeleteRequest();

            deleteRequest
                .setBizContent(JSON.toJSONString(modelRequest.getAlipayThirdAccountInfo()));

            return new ToAlipayTargetRequest(deleteRequest);

        }

        return null;
    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayRequestConverter#getSrcClass()
     */
    @Override
    public Class<? extends ToAlipayModelRequest> getSrcClass() {
        return ToAlipayDeleteAccountModelRequest.class;
    }

}
