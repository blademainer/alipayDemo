/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.ToStringBase;

/**
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayGisInfo.java, v 0.1 2014-2-22 下午5:38:51 jiehua Exp $
 */
public class ToAlipayGisInfo extends ToStringBase {

    /**  */
    private static final long serialVersionUID = -1873537582676029727L;

    /**
     * 纬度
     */
    private String            latitude;

    /**
     * 经度
     */
    private String            longitude;

    /**
     * 误差
     */
    private String            accuracy;

    /**
     * Getter method for property <tt>latitude</tt>.
     * 
     * @return property value of latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Setter method for property <tt>latitude</tt>.
     * 
     * @param latitude value to be assigned to property latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * Getter method for property <tt>longitude</tt>.
     * 
     * @return property value of longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Setter method for property <tt>longitude</tt>.
     * 
     * @param longitude value to be assigned to property longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * Getter method for property <tt>accuracy</tt>.
     * 
     * @return property value of accuracy
     */
    public String getAccuracy() {
        return accuracy;
    }

    /**
     * Setter method for property <tt>accuracy</tt>.
     * 
     * @param accuracy value to be assigned to property accuracy
     */
    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

}
