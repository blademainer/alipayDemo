/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter.to;

import com.alibaba.fastjson.JSON;
import com.alipay.api.request.AlipayMobilePublicGisGetRequest;
import com.alipay.demo.bean.to.ToAlipayGisGetModelRequest;
import com.alipay.demo.bean.to.ToAlipayModelRequest;
import com.alipay.demo.bean.to.ToAlipayTargetRequest;

/**
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayGisGetRequestConverter.java, v 0.1 2014-2-22 ÏÂÎç5:41:54 jiehua Exp $
 */
public class ToAlipayGisGetRequestConverter extends ToAlipayRequestConverter {

    /** 
     * @see com.alipay.demo.response.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ToAlipayTargetRequest convert(ToAlipayModelRequest srcObj) {

        if (srcObj != null) {

            ToAlipayGisGetModelRequest modelRequest = (ToAlipayGisGetModelRequest) srcObj;

            AlipayMobilePublicGisGetRequest gisGetRequest = new AlipayMobilePublicGisGetRequest();

            gisGetRequest.setBizContent(JSON.toJSONString(modelRequest.getAccountInfo()));

            return new ToAlipayTargetRequest(gisGetRequest);
        }

        return null;
    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayRequestConverter#getSrcClass()
     */
    @Override
    public Class<? extends ToAlipayModelRequest> getSrcClass() {
        return ToAlipayGisGetModelRequest.class;
    }

}
