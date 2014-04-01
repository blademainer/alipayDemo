/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * ������ά��ҵ������
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayQRCodeCreateModelRequest.java, v 0.1 2014-4-1 ����3:32:06 jiehua Exp $
 */
public class ToAlipayQRCodeCreateModelRequest extends ToAlipayModelRequest {

    /** ���к�id  */
    private static final long      serialVersionUID = 2422039752093734079L;

    /**
     * ����ҵ��ģ��
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
