/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayMenuQueryExecutor.java, v 0.1 2014-2-20 обнГ6:16:21 jiehua Exp $
 */
public class ToAlipayMenuQueryExecutor extends ToAlipayAPIExecutor {

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return AlipayAPINames.ALIPAY_MENU_GET_API;
    }

}
