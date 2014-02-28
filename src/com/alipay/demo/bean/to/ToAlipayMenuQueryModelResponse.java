/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

/**
 * �˵���ѯ
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayMenuQueryModelResponse.java, v 0.1 2014-2-20 ����5:52:56 jiehua Exp $
 */
public class ToAlipayMenuQueryModelResponse extends ToAlipayModelResponse {

    /** ���к� */
    private static final long serialVersionUID = 4483294968285702381L;
    /**
     * �˵�����
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
