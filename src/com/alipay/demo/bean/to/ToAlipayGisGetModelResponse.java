/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

/**
 * 业务响应
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayGisGetModelResponse.java, v 0.1 2014-2-22 下午5:40:32 jiehua Exp $
 */
public class ToAlipayGisGetModelResponse extends ToAlipayModelResponse {

    /**  */
    private static final long serialVersionUID = 526685890747096840L;
    /**
     * 地理位置信息
     */
    private ToAlipayGisInfo   gisInfo;

    /**
     * @param resultCode
     * @param resultMsg
     */
    public ToAlipayGisGetModelResponse(String resultCode, String resultMsg) {
        super(resultCode, resultMsg);
    }

    /**
     * Getter method for property <tt>gisInfo</tt>.
     * 
     * @return property value of gisInfo
     */
    public ToAlipayGisInfo getGisInfo() {
        return gisInfo;
    }

    /**
     * Setter method for property <tt>gisInfo</tt>.
     * 
     * @param gisInfo value to be assigned to property gisInfo
     */
    public void setGisInfo(ToAlipayGisInfo gisInfo) {
        this.gisInfo = gisInfo;
    }

}
