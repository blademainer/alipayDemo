/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

/**
 * �����ⲿ��ҵ����
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayResetAccountModelResponse.java, v 0.1 2014-2-21 ����2:19:17 jiehua Exp $
 */
public class ToAlipayResetAccountModelResponse extends ToAlipayModelResponse {

    /** ���к� */
    private static final long serialVersionUID = -7484631676601912197L;
    /**
     * Э���
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
