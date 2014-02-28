/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter.to;

import com.alipay.api.request.AlipayMobilePublicMenuAddRequest;
import com.alipay.demo.bean.to.ToAlipayMenuCreateModelRequest;
import com.alipay.demo.bean.to.ToAlipayModelRequest;
import com.alipay.demo.bean.to.ToAlipayTargetRequest;

/**
 * 菜单创建请求转换器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayMenuCreateRequestConverter.java, v 0.1 2014-2-21 下午1:46:09 jiehua Exp $
 */
public class ToAlipayMenuCreateRequestConverter extends ToAlipayRequestConverter {

    /** 
     * @see com.alipay.demo.response.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ToAlipayTargetRequest convert(ToAlipayModelRequest srcObj) {

        ToAlipayMenuCreateModelRequest modelRequest = (ToAlipayMenuCreateModelRequest) srcObj;

        if (modelRequest != null) {

            AlipayMobilePublicMenuAddRequest addRequest = new AlipayMobilePublicMenuAddRequest();
            addRequest.setBizContent(modelRequest.getMenuContent());

            return new ToAlipayTargetRequest(addRequest);

        }

        return null;
    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayRequestConverter#getSrcClass()
     */
    @Override
    public Class<? extends ToAlipayModelRequest> getSrcClass() {
        return ToAlipayMenuCreateModelRequest.class;
    }

}
