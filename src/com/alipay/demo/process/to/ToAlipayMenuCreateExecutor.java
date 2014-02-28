/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * 菜单创建执行器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayMenuCreateExecutor.java, v 0.1 2014-2-21 下午1:51:14 jiehua Exp $
 */
public class ToAlipayMenuCreateExecutor extends ToAlipayAPIExecutor {

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return AlipayAPINames.ALIPAY_MENU_ADD_API;
    }

}
