/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * 外部户查询执行器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayQueryAccountExecutor.java, v 0.1 2014-2-21 下午8:13:54 jiehua Exp $
 */
public class ToAlipayQueryAccountExecutor extends ToAlipayAPIExecutor {

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return AlipayAPINames.ALIPAY_QUERY_ACCOUNT_API;
    }

}
