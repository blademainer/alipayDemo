/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.ToStringBase;

/**
 *  二维码生成请求
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayQRCodeCreateInfo.java, v 0.1 2014-4-1 下午3:29:26 jiehua Exp $
 */
public class AlipayQRCodeCreateInfo extends ToStringBase {

    /** 序列号  */
    private static final long serialVersionUID = 5576212756338417428L;

    /**
     * 码类型，非空<br>
     * TEMP：临时的（默认）<br>
     * PERM：永久的
     */
    private String            codeType         = "TEMP";

    /** 
     * 临时二维码的有效期<br>
     * 以秒为单位，默认1800s，最大也是1800s
     */
    private int               expireSecond     = 1800;

    /** 码信息 */
    private AlipayQRCodeInfo  codeInfo;

    /**
     * 中间是否显示logo<br>
     * Y：显示  <br>
     * N：不显示（默认）
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
