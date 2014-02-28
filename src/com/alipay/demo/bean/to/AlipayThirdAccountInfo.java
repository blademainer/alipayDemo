/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import java.io.Serializable;

import com.alipay.demo.bean.ToStringBase;

/**
 * ���ⲿ����Ϣ
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayThirdAccountInfo.java, v 0.1 2014-1-10 ����10:06:02 jie.hua Exp $
 */
public class AlipayThirdAccountInfo extends ToStringBase implements Serializable {

    /** ���к�ID */
    private static final long serialVersionUID = 3697014169147539263L;

    /**
     * ���ں�ID
     */
    private String            appId;

    /**
     * չʾ����
     */
    private String            displayName;

    /**
     * ʵ������
     */
    private String            realName;

    /**
     * �󶨵��ⲿ�˻�ID
     */
    private String            bindAccountNo;

    /**
     * ����󶨵�֧����UID
     */
    private String            fromUserId;

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
     * Getter method for property <tt>displayName</tt>.
     * 
     * @return property value of displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Setter method for property <tt>displayName</tt>.
     * 
     * @param displayName value to be assigned to property displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Getter method for property <tt>realName</tt>.
     * 
     * @return property value of realName
     */
    public String getRealName() {
        return realName;
    }

    /**
     * Setter method for property <tt>realName</tt>.
     * 
     * @param realName value to be assigned to property realName
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * Getter method for property <tt>bindAccountNo</tt>.
     * 
     * @return property value of bindAccountNo
     */
    public String getBindAccountNo() {
        return bindAccountNo;
    }

    /**
     * Setter method for property <tt>bindAccountNo</tt>.
     * 
     * @param bindAccountNo value to be assigned to property bindAccountNo
     */
    public void setBindAccountNo(String bindAccountNo) {
        this.bindAccountNo = bindAccountNo;
    }

    /**
     * Getter method for property <tt>fromUserId</tt>.
     * 
     * @return property value of fromUserId
     */
    public String getFromUserId() {
        return fromUserId;
    }

    /**
     * Setter method for property <tt>fromUserId</tt>.
     * 
     * @param fromUserId value to be assigned to property fromUserId
     */
    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

}
