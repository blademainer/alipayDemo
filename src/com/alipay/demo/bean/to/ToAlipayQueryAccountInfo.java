/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.ToStringBase;

/**
 * 查询外部户信息
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayQueryAccountInfo.java, v 0.1 2014-2-22 上午11:39:38 jiehua Exp $
 */
public class ToAlipayQueryAccountInfo extends ToStringBase {

    /**  */
    private static final long serialVersionUID = 8086348872085997266L;
    /**
     * 支付宝UID
     */
    private String            userId;

    /**
     * Getter method for property <tt>userId</tt>.
     * 
     * @return property value of userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Setter method for property <tt>userId</tt>.
     * 
     * @param userId value to be assigned to property userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

}
