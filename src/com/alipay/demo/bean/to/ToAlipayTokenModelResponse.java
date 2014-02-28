/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

/**
 * 
 * ��Ȩ�����󷵻���Ϣ
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayTokenModelResponse.java, v 0.1 2014-2-20 ����3:43:28 jiehua Exp $
 */
public class ToAlipayTokenModelResponse extends ToAlipayModelResponse {

    /** ���к� */
    private static final long     serialVersionUID = -1285445322501297850L;
    /**
     * ��ȡ����Ϣ
     */
    private AlipayAccessTokenInfo alipayAccessTokenInfo;

    /**
     * @param resultCode
     * @param resultMsg
     */
    public ToAlipayTokenModelResponse(String resultCode, String resultMsg) {
        super(resultCode, resultMsg);
    }

    /**
     * Getter method for property <tt>alipayAccessTokenInfo</tt>.
     * 
     * @return property value of alipayAccessTokenInfo
     */
    public AlipayAccessTokenInfo getAlipayAccessTokenInfo() {
        return alipayAccessTokenInfo;
    }

    /**
     * Setter method for property <tt>alipayAccessTokenInfo</tt>.
     * 
     * @param alipayAccessTokenInfo value to be assigned to property alipayAccessTokenInfo
     */
    public void setAlipayAccessTokenInfo(AlipayAccessTokenInfo alipayAccessTokenInfo) {
        this.alipayAccessTokenInfo = alipayAccessTokenInfo;
    }

}
