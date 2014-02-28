/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * �̻�->֧�������˻�ҵ������
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayAddAccountModelRequest.java, v 0.1 2014-1-10 ����11:59:56 jie.hua Exp $
 */
public class ToAlipayAddAccountModelRequest extends ToAlipayModelRequest {

    /** ���к�ID  */
    private static final long      serialVersionUID = 2896885811439637621L;
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

        return AlipayAPINames.ALIPAY_ADD_ACCOUNT_API;
    }

}
