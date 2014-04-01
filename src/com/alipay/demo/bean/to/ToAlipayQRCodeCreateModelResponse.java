/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

/**
 * ������ά����Ӧ
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayQRCodeCreateModelResponse.java, v 0.1 2014-4-1 ����8:11:07 jiehua Exp $
 */
public class ToAlipayQRCodeCreateModelResponse extends ToAlipayModelResponse {

    /** ���к� */
    private static final long serialVersionUID = 2593918414147089821L;

    /**
     * ͼƬ��ַ
     */
    private String            imageUrl;

    /**
     * ��Чʱ��
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
