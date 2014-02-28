/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * 重置外部户执行器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayResetAccountExecutor.java, v 0.1 2014-2-21 下午4:28:22 jiehua Exp $
 */
public class ToAlipayResetAccountExecutor extends ToAlipayAPIExecutor {

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return AlipayAPINames.ALIPAY_RESET_ACCOUNT_API;
    }

}
