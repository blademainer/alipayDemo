/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.ToStringBase;

/**
 * ��ά����Ϣ
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayQRCodeInfo.java, v 0.1 2014-4-1 ����3:21:28 jiehua Exp $
 */
public class AlipayQRCodeInfo extends ToStringBase {

    /** ���к� */
    private static final long serialVersionUID = 6763800801357726407L;

    /** ���� */
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
