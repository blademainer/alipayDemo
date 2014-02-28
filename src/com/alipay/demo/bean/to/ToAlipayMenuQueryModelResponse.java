/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

/**
 * 菜单查询
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayMenuQueryModelResponse.java, v 0.1 2014-2-20 下午5:52:56 jiehua Exp $
 */
public class ToAlipayMenuQueryModelResponse extends ToAlipayModelResponse {

    /** 序列号 */
    private static final long serialVersionUID = 4483294968285702381L;
    /**
     * 菜单内容
     */
    private String            menuContent;

    /**
     * @param resultCode
     * @param resultMsg
     */
    public ToAlipayMenuQueryModelResponse(String resultCode, String resultMsg) {
        super(resultCode, resultMsg);
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
