/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * 菜单创建业务请求
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayMenuCreateModelRequest.java, v 0.1 2014-2-21 下午1:43:21 jiehua Exp $
 */
public class ToAlipayMenuCreateModelRequest extends ToAlipayModelRequest {

    /** 序列号 */
    private static final long serialVersionUID = -9107298887177534784L;

    /**
     * 菜单内容
     */
    private String            menuContent;

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return AlipayAPINames.ALIPAY_MENU_ADD_API;
    }

    /**
     * Getter method for property <tt>menuContent</tt>.
     * 
     * @return property value of menuContent
     */
    public String getMenuContent() {
        return menuContent;
    }

    /**
     * Setter method for property <tt>menuContent</tt>.
     * 
     * @param menuContent value to be assigned to property menuContent
     */
    public void setMenuContent(String menuContent) {
        this.menuContent = menuContent;
    }

}
