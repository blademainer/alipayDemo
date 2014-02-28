/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * ��Ȩtoken��ȡִ����
 * 
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipaySystemTokenGetExecutor.java, v 0.1 2014-2-20 ����2:42:24 jiehua Exp $
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
