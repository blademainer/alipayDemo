/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * 菜单查询业务请求
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayMenuQueryModelRequest.java, v 0.1 2014-2-20 下午5:56:02 jiehua Exp $
 */
public class ToAlipayMenuQueryModelRequest extends ToAlipayModelRequest {

    /**  */
    private static final long serialVersionUID = -8428011727492793910L;

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return AlipayAPINames.ALIPAY_MENU_GET_API;
    }

}
