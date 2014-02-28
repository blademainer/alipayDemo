/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter.to;

import com.alipay.api.request.AlipayMobilePublicMenuUpdateRequest;
import com.alipay.demo.bean.to.ToAlipayMenuUpdateModelRequest;
import com.alipay.demo.bean.to.ToAlipayModelRequest;
import com.alipay.demo.bean.to.ToAlipayTargetRequest;

/**
 * 
 * �˵�����ת����
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayMenuUpdateRequestConverter.java, v 0.1 2014-2-21 ����10:02:37 jiehua Exp $
 */
public class ToAlipayMenuUpdateRequestConverter extends ToAlipayRequestConverter {

    /** 
     * @see com.alipay.demo.response.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ToAlipayTargetRequest convert(ToAlipayModelRequest srcObj) {

        ToAlipayMenuUpdateModelRequest modelRequest = (ToAlipayMenuUpdateModelRequest) srcObj;

        if (modelRequest != null) {

            AlipayMobilePublicMenuUpdateRequest updateRequest = new AlipayMobilePublicMenuUpdateRequest();

            updateRequest.setBizContent(modelRequest.getMenuContent());

            // 2.ת����Ŀ������
            return new ToAlipayTargetRequest(updateRequest);
        }

        return null;
    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayRequestConverter#getSrcClass()
     */
    @Override
    public Class<? extends ToAlipayModelRequest> getSrcClass() {
        return ToAlipayMenuUpdateModelRequest.class;
    }

}
