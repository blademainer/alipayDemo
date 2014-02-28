/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.in;

import com.alipay.demo.bean.ToStringBase;

/**
 * 支付宝授权信息
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayInAuthInfo.java, v 0.1 2014-2-15 下午5:20:38 jiehua Exp $
 */
public class AlipayInAuthInfo extends ToStringBase {

    /** 序列号 */
    private static final long serialVersionUID = -3848025169704694489L;

    /**
     * 公众号ID
     */
    private String            appId;

    /**
     * 公众号ID
     */
    private String            publicId;

    /**
     * 授权码
     */
    private String            authCode;

    /**
     * 授权方式
     */
    private String            alipayAuth;

    /**
     * 支付宝USERID: 后续会删除，此处仅仅用于简单演示
     */
    @Deprecated
    private String            alipayUserId;

    /**
     * 来源
     */
    private String            sourceId;

    /**
     * Getter method for property <tt>appId</tt>.
     * 
     * @return property value of appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * Setter method for property <tt>appId</tt>.
     * 
     * @param appId value to be assigned to property appId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * Getter method for property <tt>publicId</tt>.
     * 
     * @return property value of publicId
     */
    public String getPublicId() {
        return publicId;
    }

    /**
     * Setter method for property <tt>publicId</tt>.
     * 
     * @param publicId value to be assigned to property publicId
     */
    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    /**
     * Getter method for property <tt>authCode</tt>.
     * 
     * @return property value of authCode
     */
    public String getAuthCode() {
        return authCode;
    }

    /**
     * Setter method for property <tt>authCode</tt>.
     * 
     * @param authCode value to be assigned to property authCode
     */
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    /**
     * Getter method for property <tt>alipayAuth</tt>.
     * 
     * @return property value of alipayAuth
     */
    public String getAlipayAuth() {
        return alipayAuth;
    }

    /**
     * Setter method for property <tt>alipayAuth</tt>.
     * 
     * @param alipayAuth value to be assigned to property alipayAuth
     */
    public void setAlipayAuth(String alipayAuth) {
        this.alipayAuth = alipayAuth;
    }

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
     * Getter method for property <tt>sourceId</tt>.
     * 
     * @return property value of sourceId
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * Setter method for property <tt>sourceId</tt>.
     * 
     * @param sourceId value to be assigned to property sourceId
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

}
