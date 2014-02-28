/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

/**
 * 删除外部户响应
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayDeleteAccountModelResponse.java, v 0.1 2014-2-22 下午5:04:54 jiehua Exp $
 */
public class ToAlipayDeleteAccountModelResponse extends ToAlipayModelResponse {

    /**  */
    private static final long serialVersionUID = 815677502123037065L;
    /**
     * 协议号
     */
    private String            agreementId;

    /**
     * @param resultCode
     * @param resultMsg
     */
    public ToAlipayDeleteAccountModelResponse(String resultCode, String resultMsg) {
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
