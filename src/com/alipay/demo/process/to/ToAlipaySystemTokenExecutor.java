/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * 授权token换取执行器
 * 
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipaySystemTokenGetExecutor.java, v 0.1 2014-2-20 下午2:42:24 jiehua Exp $
 */
public class ToAlipaySystemTokenExecutor extends ToAlipayAPIExecutor {

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return AlipayAPINames.ALIPAY_SYSTEM_OAUTH_TOKEN_API;
    }

}
