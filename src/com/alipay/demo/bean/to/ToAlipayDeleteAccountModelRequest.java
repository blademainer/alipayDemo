/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * 删除外部户
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayDeleteAccountModelRequest.java, v 0.1 2014-2-22 下午5:03:43 jiehua Exp $
 */
public class ToAlipayDeleteAccountModelRequest extends ToAlipayModelRequest {

    /**  */
    private static final long      serialVersionUID = 3223314110856590213L;
    /**
     * 外部户信息
     */
    private AlipayThirdAccountInfo alipayThirdAccountInfo;

    /**
     * Getter method for property <tt>alipayThirdAccountInfo</tt>.
     * 
     * @return property value of alipayThirdAccountInfo
     */
    public AlipayThirdAccountInfo getAlipayThirdAccountInfo() {
        return alipayThirdAccountInfo;
    }

    /**
     * Setter method for property <tt>alipayThirdAccountInfo</tt>.
     * 
     * @param alipayThirdAccountInfo value to be assigned to property alipayThirdAccountInfo
     */
    public void setAlipayThirdAccountInfo(AlipayThirdAccountInfo alipayThirdAccountInfo) {
        this.alipayThirdAccountInfo = alipayThirdAccountInfo;
    }

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return AlipayAPINames.ALIPAY_DELETE_ACCOUNT_API;
    }
}
