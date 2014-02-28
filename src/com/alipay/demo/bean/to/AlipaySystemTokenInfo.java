/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.ToStringBase;

/**
 * 支付宝授权码信息
 * 
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayAuthCodeInfo.java, v 0.1 2014-2-20 下午2:44:30 jiehua Exp $
 */
public class AlipaySystemTokenInfo extends ToStringBase {

    /** 序列号 */
    private static final long serialVersionUID = 818176477385892932L;

    /**
     * 授权类型
     */
    private String            grantType        = "authorization_code";

    private String            authCode;

    /**
     * Getter method for property <tt>grantType</tt>.
     * 
     * @return property value of grantType
     */
    public String getGrantType() {
        return grantType;
    }

    /**
     * Setter method for property <tt>grantType</tt>.
     * 
     * @param grantType value to be assigned to property grantType
     */
    public void setGrantType(String grantType) {
        this.grantType = grantType;
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

}
