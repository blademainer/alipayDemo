/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * �ⲿ������ҵ������
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayResetAccountModelRequest.java, v 0.1 2014-2-21 ����2:12:26 jiehua Exp $
 */
public class ToAlipayResetAccountModelRequest extends ToAlipayModelRequest {

    /** ���к� */
    private static final long      serialVersionUID = 7215985535973873972L;
    /**
     * �ⲿ����Ϣ
     */
    private AlipayThirdAccountInfo alipayThirdAccountInfo;

    /**
     * Getter method for property <tt>alipayThirdAccountInfo</tt>.
     * 
     * @return property value of alipayThirdAccountInfo
     */
    public AlipayThirdAccountInfo getAlipayAddAccountInfo() {
        return alipayThirdAccountInfo;
    }

    /**
     * Setter method for property <tt>alipayThirdAccountInfo</tt>.
     * 
     * @param alipayThirdAccountInfo value to be assigned to property alipayThirdAccountInfo
     */
    public void setAlipayAddAccountInfo(AlipayThirdAccountInfo alipayThirdAccountInfo) {
        this.alipayThirdAccountInfo = alipayThirdAccountInfo;
    }

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return AlipayAPINames.ALIPAY_RESET_ACCOUNT_API;
    }

}
