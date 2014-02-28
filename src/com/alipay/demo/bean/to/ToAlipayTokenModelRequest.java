/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * 授权业务请求
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayTokenModelRequest.java, v 0.1 2014-2-20 下午3:19:28 jiehua Exp $
 */
public class ToAlipayTokenModelRequest extends ToAlipayModelRequest {

    /** 序列号 */
    private static final long     serialVersionUID = -5723852332342567649L;
    /**
     * 支付宝授权信息
     */
    private AlipaySystemTokenInfo alipaySystemTokenInfo;

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return AlipayAPINames.ALIPAY_SYSTEM_OAUTH_TOKEN_API;
    }

    /**
     * Getter method for property <tt>alipaySystemTokenInfo</tt>.
     * 
     * @return property value of alipaySystemTokenInfo
     */
    public AlipaySystemTokenInfo getAlipaySystemTokenInfo() {
        return alipaySystemTokenInfo;
    }

    /**
     * Setter method for property <tt>alipaySystemTokenInfo</tt>.
     * 
     * @param alipaySystemTokenInfo value to be assigned to property alipaySystemTokenInfo
     */
    public void setAlipaySystemTokenInfo(AlipaySystemTokenInfo alipaySystemTokenInfo) {
        this.alipaySystemTokenInfo = alipaySystemTokenInfo;
    }

}
