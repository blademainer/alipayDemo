/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.ToStringBase;

/**
 * 二维码信息
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayQRCodeInfo.java, v 0.1 2014-4-1 下午3:21:28 jiehua Exp $
 */
public class AlipayQRCodeInfo extends ToStringBase {

    /** 序列号 */
    private static final long serialVersionUID = 6763800801357726407L;

    /** 场景 */
    private AlipayQRScene     scene;

    /**
     * Getter method for property <tt>scene</tt>.
     * 
     * @return property value of scene
     */
    public AlipayQRScene getScene() {
        return scene;
    }

    /**
     * Setter method for property <tt>scene</tt>.
     * 
     * @param scene value to be assigned to property scene
     */
    public void setScene(AlipayQRScene scene) {
        this.scene = scene;
    }

}
