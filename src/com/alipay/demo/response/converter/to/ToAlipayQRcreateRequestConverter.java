/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter.to;

import com.alibaba.fastjson.JSON;
import com.alipay.api.request.AlipayMobilePublicQrcodeCreateRequest;
import com.alipay.demo.bean.to.ToAlipayModelRequest;
import com.alipay.demo.bean.to.ToAlipayQRCodeCreateModelRequest;
import com.alipay.demo.bean.to.ToAlipayTargetRequest;

/**
 * 二维码创建请求转换器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayQRcreateRequestConverter.java, v 0.1 2014-4-1 下午8:13:59 jiehua Exp $
 */
public class ToAlipayQRcreateRequestConverter extends ToAlipayRequestConverter {

    /** 
     * @see com.alipay.demo.response.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ToAlipayTargetRequest convert(ToAlipayModelRequest srcObj) {

        ToAlipayQRCodeCreateModelRequest modelRequest = (ToAlipayQRCodeCreateModelRequest) srcObj;

        if (modelRequest != null) {

            AlipayMobilePublicQrcodeCreateRequest createRequest = new AlipayMobilePublicQrcodeCreateRequest();

            createRequest.setBizContent(JSON.toJSONString(modelRequest.getInfo()));

            return new ToAlipayTargetRequest(createRequest);

        }

        return null;
    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayRequestConverter#getSrcClass()
     */
    @Override
    public Class<? extends ToAlipayModelRequest> getSrcClass() {
        return ToAlipayQRCodeCreateModelRequest.class;
    }

}
