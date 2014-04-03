/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * ɾ���ⲿ��ִ����
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayDelAccountExecutor.java, v 0.1 2014-4-3 ����11:45:38 jiehua Exp $
 */
public class ToAlipayDelAccountExecutor extends ToAlipayAPIExecutor {

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return AlipayAPINames.ALIPAY_DELETE_ACCOUNT_API;
    }

}
