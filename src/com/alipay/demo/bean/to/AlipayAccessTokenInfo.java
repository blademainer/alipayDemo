/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.ToStringBase;

/**
 * ��Ȩ�뻻ȡ�ķ�������Ϣ
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayAccessTokenInfo.java, v 0.1 2014-2-20 ����3:40:03 jiehua Exp $
 */
public class AlipayAccessTokenInfo extends ToStringBase {

    /** ���к�  */
    private static final long serialVersionUID = -2462342384272175L;

    /**
     * ֧����userId
     */
    private String            alipayUserId;

    /**
     * ��Ȩ��
     */
    private String            accessToken;

    /**
     * �������Ƶ���Ч��
     */
    private String            expireIn;

    /**
     * ˢ����
     */
    private String            refreshToken;

    /**
     * ˢ��������Ч��
     */
    private String            reExpireIn;

    /**
     * Getter method for property <tt>alipayUserId</tt>.
     * 
     * @return property value of alipayUserId
     */
    public String getAlipayUserId() {
        return alipayUserId;
    }

    /**
     * Setter method for property <tt>alipayUserId</tt>.
     * 
     * @param alipayUserId value to be assigned to property alipayUserId
     */
    public void setAlipayUserId(String alipayUserId) {
        this.alipayUserId = alipayUserId;
    }

    /**
     * Getter method for property <tt>accessToken</tt>.
     * 
     * @return property value of accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Setter method for property <tt>accessToken</tt>.
     * 
     * @param accessToken value to be assigned to property accessToken
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Getter method for property <tt>expireIn</tt>.
     * 
     * @return property value of expireIn
     */
    public String getExpireIn() {
        return expireIn;
    }

    /**
     * Setter method for property <tt>expireIn</tt>.
     * 
     * @param expireIn value to be assigned to property expireIn
     */
    public void setExpireIn(String expireIn) {
        this.expireIn = expireIn;
    }

    /**
     * Getter method for property <tt>refreshToken</tt>.
     * 
     * @return property value of refreshToken
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * Setter method for property <tt>refreshToken</tt>.
     * 
     * @param refreshToken value to be assigned to property refreshToken
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * Getter method for property <tt>reExpireIn</tt>.
     * 
     * @return property value of reExpireIn
     */
    public String getReExpireIn() {
        return reExpireIn;
    }

    /**
     * Setter method for property <tt>reExpireIn</tt>.
     * 
     * @param reExpireIn value to be assigned to property reExpireIn
     */
    public void setReExpireIn(String reExpireIn) {
        this.reExpireIn = reExpireIn;
    }

}
