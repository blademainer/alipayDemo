/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayGisGetModelRequest.java, v 0.1 2014-2-22 下午5:32:52 jiehua Exp $
 */
public class ToAlipayGisGetModelRequest extends ToAlipayModelRequest {

    /**  */
    private static final long        serialVersionUID = -5997284314333451942L;
    /**
     * 查询外部户信息
     */
    private ToAlipayQueryAccountInfo accountInfo;

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return AlipayAPINames.ALIPAY_GIS_GET_API;
    }

    /**
     * Getter method for property <tt>accountInfo</tt>.
     * 
     * @return property value of accountInfo
     */
    public ToAlipayQueryAccountInfo getAccountInfo() {
        return accountInfo;
    }

    /**
     * Setter method for property <tt>accountInfo</tt>.
     * 
     * @param accountInfo value to be assigned to property accountInfo
     */
    public void setAccountInfo(ToAlipayQueryAccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

}
