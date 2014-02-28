/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter.to;

import com.alibaba.fastjson.JSON;
import com.alipay.api.request.AlipayMobilePublicAccountQueryRequest;
import com.alipay.demo.bean.to.ToAlipayModelRequest;
import com.alipay.demo.bean.to.ToAlipayQueryAccountModelRequest;
import com.alipay.demo.bean.to.ToAlipayTargetRequest;

/**
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayQueryAccountRequestConverter.java, v 0.1 2014-2-22 ÉÏÎç11:35:36 jiehua Exp $
 */
public class ToAlipayQueryAccountRequestConverter extends ToAlipayRequestConverter {

    /** 
     * @see com.alipay.demo.response.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ToAlipayTargetRequest convert(ToAlipayModelRequest srcObj) {

        if (srcObj != null) {

            ToAlipayQueryAccountModelRequest modelRequest = (ToAlipayQueryAccountModelRequest) srcObj;

            AlipayMobilePublicAccountQueryRequest queryRequest = new AlipayMobilePublicAccountQueryRequest();

            queryRequest.setBizContent(JSON.toJSONString(modelRequest.getAccountInfo()));

            return new ToAlipayTargetRequest(queryRequest);

        }

        return null;
    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayRequestConverter#getSrcClass()
     */
    @Override
    public Class<? extends ToAlipayModelRequest> getSrcClass() {

        return ToAlipayQueryAccountModelRequest.class;
    }

}
