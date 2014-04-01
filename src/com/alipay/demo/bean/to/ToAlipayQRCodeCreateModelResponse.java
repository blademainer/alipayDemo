/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

/**
 * 创建二维码响应
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayQRCodeCreateModelResponse.java, v 0.1 2014-4-1 下午8:11:07 jiehua Exp $
 */
public class ToAlipayQRCodeCreateModelResponse extends ToAlipayModelResponse {

    /** 序列号 */
    private static final long serialVersionUID = 2593918414147089821L;

    /**
     * 图片地址
     */
    private String            imageUrl;

    /**
     * 有效时长
     */
    private long              expiredTime;

    /**
     * @param resultCode
     * @param resultMsg
     */
    public ToAlipayQRCodeCreateModelResponse(String resultCode, String resultMsg) {
        super(resultCode, resultMsg);
    }

    /**
     * Getter method for property <tt>imageUrl</tt>.
     * 
     * @return property value of imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Setter method for property <tt>imageUrl</tt>.
     * 
     * @param imageUrl value to be assigned to property imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Getter method for property <tt>expiredTime</tt>.
     * 
     * @return property value of expiredTime
     */
    public long getExpiredTime() {
        return expiredTime;
    }

    /**
     * Setter method for property <tt>expiredTime</tt>.
     * 
     * @param expiredTime value to be assigned to property expiredTime
     */
    public void setExpiredTime(long expiredTime) {
        this.expiredTime = expiredTime;
    }

}
