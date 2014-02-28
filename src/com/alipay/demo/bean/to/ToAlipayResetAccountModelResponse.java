/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

/**
 * 重置外部户业务结果
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayResetAccountModelResponse.java, v 0.1 2014-2-21 下午2:19:17 jiehua Exp $
 */
public class ToAlipayResetAccountModelResponse extends ToAlipayModelResponse {

    /** 序列号 */
    private static final long serialVersionUID = -7484631676601912197L;
    /**
     * 协议号
     */
    private String            agreementId;

    /**
     * @param resultCode
     * @param resultMsg
     */
    public ToAlipayResetAccountModelResponse(String resultCode, String resultMsg) {
        super(resultCode, resultMsg);
    }

    /**
     * Getter method for property <tt>agreementId</tt>.
     * 
     * @return property value of agreementId
     */
    public String getAgreementId() {
        return agreementId;
    }

    /**
     * Setter method for property <tt>agreementId</tt>.
     * 
     * @param agreementId value to be assigned to property agreementId
     */
    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

}
