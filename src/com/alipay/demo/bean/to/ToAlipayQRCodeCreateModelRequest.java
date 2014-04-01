/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * 创建二维码业务请求
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayQRCodeCreateModelRequest.java, v 0.1 2014-4-1 下午3:32:06 jiehua Exp $
 */
public class ToAlipayQRCodeCreateModelRequest extends ToAlipayModelRequest {

    /** 序列号id  */
    private static final long      serialVersionUID = 2422039752093734079L;

    /**
     * 创建业务模型
     */
    private AlipayQRCodeCreateInfo info;

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return AlipayAPINames.ALIPAY_GEN_QR_CODE_API;
    }

    /**
     * Getter method for property <tt>info</tt>.
     * 
     * @return property value of info
     */
    public AlipayQRCodeCreateInfo getInfo() {
        return info;
    }

    /**
     * Setter method for property <tt>info</tt>.
     * 
     * @param info value to be assigned to property info
     */
    public void setInfo(AlipayQRCodeCreateInfo info) {
        this.info = info;
    }

}
