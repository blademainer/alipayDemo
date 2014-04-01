/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * 
 * ��ά��ͼƬ����ִ����
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayQRCreateExecutor.java, v 0.1 2014-4-1 ����8:26:01 jiehua Exp $
 */
public class ToAlipayQRCreateExecutor extends ToAlipayAPIExecutor {

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return AlipayAPINames.ALIPAY_GEN_QR_CODE_API;
    }

}
