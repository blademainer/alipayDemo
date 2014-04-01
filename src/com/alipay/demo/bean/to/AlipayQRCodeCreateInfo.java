/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.ToStringBase;

/**
 *  ��ά����������
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayQRCodeCreateInfo.java, v 0.1 2014-4-1 ����3:29:26 jiehua Exp $
 */
public class AlipayQRCodeCreateInfo extends ToStringBase {

    /** ���к�  */
    private static final long serialVersionUID = 5576212756338417428L;

    /**
     * �����ͣ��ǿ�<br>
     * TEMP����ʱ�ģ�Ĭ�ϣ�<br>
     * PERM�����õ�
     */
    private String            codeType         = "TEMP";

    /** 
     * ��ʱ��ά�����Ч��<br>
     * ����Ϊ��λ��Ĭ��1800s�����Ҳ��1800s
     */
    private int               expireSecond     = 1800;

    /** ����Ϣ */
    private AlipayQRCodeInfo  codeInfo;

    /**
     * �м��Ƿ���ʾlogo<br>
     * Y����ʾ  <br>
     * N������ʾ��Ĭ�ϣ�
     */
    private String            showLogo         = "N";

    /**
     * Getter method for property <tt>codeType</tt>.
     * 
     * @return property value of codeType
     */
    public String getCodeType() {
        return codeType;
    }

    /**
     * Setter method for property <tt>codeType</tt>.
     * 
     * @param codeType value to be assigned to property codeType
     */
    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    /**
     * Getter method for property <tt>expireSecond</tt>.
     * 
     * @return property value of expireSecond
     */
    public int getExpireSecond() {
        return expireSecond;
    }

    /**
     * Setter method for property <tt>expireSecond</tt>.
     * 
     * @param expireSecond value to be assigned to property expireSecond
     */
    public void setExpireSecond(int expireSecond) {
        this.expireSecond = expireSecond;
    }

    /**
     * Getter method for property <tt>codeInfo</tt>.
     * 
     * @return property value of codeInfo
     */
    public AlipayQRCodeInfo getCodeInfo() {
        return codeInfo;
    }

    /**
     * Setter method for property <tt>codeInfo</tt>.
     * 
     * @param codeInfo value to be assigned to property codeInfo
     */
    public void setCodeInfo(AlipayQRCodeInfo codeInfo) {
        this.codeInfo = codeInfo;
    }

    /**
     * Getter method for property <tt>showLogo</tt>.
     * 
     * @return property value of showLogo
     */
    public String getShowLogo() {
        return showLogo;
    }

    /**
     * Setter method for property <tt>showLogo</tt>.
     * 
     * @param showLogo value to be assigned to property showLogo
     */
    public void setShowLogo(String showLogo) {
        this.showLogo = showLogo;
    }

}
