/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter.to;

import com.alipay.api.request.AlipayMobilePublicMenuGetRequest;
import com.alipay.demo.bean.to.ToAlipayMenuQueryModelRequest;
import com.alipay.demo.bean.to.ToAlipayModelRequest;
import com.alipay.demo.bean.to.ToAlipayTargetRequest;

/**
 * 菜单查询请求转换器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayMenuQueryRequestConverter.java, v 0.1 2014-2-20 下午5:57:53 jiehua Exp $
 */
public class ToAlipayMenuQueryRequestConverter extends ToAlipayRequestConverter {

    /** 
     * @see com.alipay.demo.response.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ToAlipayTargetRequest convert(ToAlipayModelRequest srcObj) {

        AlipayMobilePublicMenuGetRequest request = new AlipayMobilePublicMenuGetRequest();

        return new ToAlipayTargetRequest(request);
    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayRequestConverter#getSrcClass()
     */
    @Override
    public Class<? extends ToAlipayModelRequest> getSrcClass() {
        return ToAlipayMenuQueryModelRequest.class;
    }

}
