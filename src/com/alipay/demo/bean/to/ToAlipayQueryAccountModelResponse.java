/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import java.util.List;

import com.alipay.api.domain.PublicBindAccount;

/**
 * 查询外部户业务响应
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayQueryAccountModelResponse.java, v 0.1 2014-2-21 下午6:00:19 jiehua Exp $
 */
public class ToAlipayQueryAccountModelResponse extends ToAlipayModelResponse {

    /**  */
    private static final long       serialVersionUID = 1170680480559974139L;

    /**
     * 外部户内容
     */
    private List<PublicBindAccount> bindAccountList;

    /**
     * @param resultCode
     * @param resultMsg
     */
    public ToAlipayQueryAccountModelResponse(String resultCode, String resultMsg) {
        super(resultCode, resultMsg);
    }

    /**
     * Getter method for property <tt>bindAccountList</tt>.
     * 
     * @return property value of bindAccountList
     */
    public List<PublicBindAccount> getBindAccountList() {
        return bindAccountList;
    }

    /**
     * Setter method for property <tt>bindAccountList</tt>.
     * 
     * @param bindAccountList value to be assigned to property bindAccountList
     */
    public void setBindAccountList(List<PublicBindAccount> bindAccountList) {
        this.bindAccountList = bindAccountList;
    }

}
