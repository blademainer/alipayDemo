/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * 支付宝外部户查询业务请求
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayQueryAccountModelRequest.java, v 0.1 2014-2-21 下午5:57:04 jiehua Exp $
 */
public class ToAlipayQueryAccountModelRequest extends ToAlipayModelRequest {

    /** 序列号 */
    private static final long        serialVersionUID = -3711382042982953577L;

    /**
     * 查询外部户信息
     */
    private ToAlipayQueryAccountInfo accountInfo;

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return AlipayAPINames.ALIPAY_QUERY_ACCOUNT_API;
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
