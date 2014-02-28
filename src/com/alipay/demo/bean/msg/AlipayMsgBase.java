/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.msg;

import java.util.Date;

import com.alipay.demo.bean.ToStringBase;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * ��֧�������͵���Ϣ��
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayXMLMsg.java, v 0.1 2014-1-6 ����1:38:37 jie.hua Exp $
 */
@XStreamAlias("XML")
public class AlipayMsgBase extends ToStringBase {

    /** ���к�ID */
    private static final long serialVersionUID = 1766775190503432378L;

    /**
     * ���ں�ID
     */
    @XStreamAlias("AppId")
    private String            appId;

    /**
     * ֧��������UID
     */
    @XStreamAlias("ToUserId")
    private String            toUserId;

    /**
     * Э���
     */
    @XStreamAlias("AgreementId")
    private String            agreementId;

    /**
     * ����ʱ��
     */
    @XStreamAlias("CreateTime")
    private Date              createTime;

    /**
     * ��Ϣ����
     */
    @XStreamAlias("MsgType")
    private String            msgType;

    /**
     * չʾ��ʽ
     */
    @XStreamAlias("ShowType")
    private String            showType;

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
     * Getter method for property <tt>toUserId</tt>.
     * 
     * @return property value of toUserId
     */
    public String getToUserId() {
        return toUserId;
    }

    /**
     * Setter method for property <tt>toUserId</tt>.
     * 
     * @param toUserId value to be assigned to property toUserId
     */
    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
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

    /**
     * Getter method for property <tt>createTime</tt>.
     * 
     * @return property value of createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * Setter method for property <tt>createTime</tt>.
     * 
     * @param createTime value to be assigned to property createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * Getter method for property <tt>msgType</tt>.
     * 
     * @return property value of msgType
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * Setter method for property <tt>msgType</tt>.
     * 
     * @param msgType value to be assigned to property msgType
     */
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    /**
     * Getter method for property <tt>showType</tt>.
     * 
     * @return property value of showType
     */
    public String getShowType() {
        return showType;
    }

    /**
     * Setter method for property <tt>showType</tt>.
     * 
     * @param showType value to be assigned to property showType
     */
    public void setShowType(String showType) {
        this.showType = showType;
    }

}
