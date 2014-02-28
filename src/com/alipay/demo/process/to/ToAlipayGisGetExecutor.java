/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayGisGetExecutor.java, v 0.1 2014-2-22 обнГ5:50:56 jiehua Exp $
 */
public class ToAlipayGisGetExecutor extends ToAlipayAPIExecutor {

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return AlipayAPINames.ALIPAY_GIS_GET_API;
    }

}
