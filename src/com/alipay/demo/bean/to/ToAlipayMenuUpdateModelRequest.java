/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * 菜单更新业务请求
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayMenuUpdateModelRequest.java, v 0.1 2014-2-21 上午9:05:36 jiehua Exp $
 */
public class ToAlipayMenuUpdateModelRequest extends ToAlipayModelRequest {

    /**  */
    private static final long serialVersionUID = 2541241475351831008L;
    /**
     * 菜单数据
     */
    private String            menuContent;

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return AlipayAPINames.ALIPAY_MENU_UPDATE_API;
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
