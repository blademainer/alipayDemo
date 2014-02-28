/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * 菜单更新执行器
 * 
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayMenuUpdateExecutor.java, v 0.1 2014-2-21 上午10:09:58 jiehua Exp $
 */
public class ToAlipayMenuUpdateExecutor extends ToAlipayAPIExecutor {

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return AlipayAPINames.ALIPAY_MENU_UPDATE_API;
    }

}
