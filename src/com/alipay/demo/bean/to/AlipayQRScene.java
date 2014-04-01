/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.ToStringBase;

/**
 * ֧������ά�볡��ֵ
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayQRScene.java, v 0.1 2014-4-1 ����3:20:20 jiehua Exp $
 */
public class AlipayQRScene extends ToStringBase {

    /** ���к�ID */
    private static final long serialVersionUID = 8929043478241318098L;

    /** ����Id */
    private String            sceneId;

    /**
     * Getter method for property <tt>sceneId</tt>.
     * 
     * @return property value of sceneId
     */
    public String getSceneId() {
        return sceneId;
    }

    /**
     * Setter method for property <tt>sceneId</tt>.
     * 
     * @param sceneId value to be assigned to property sceneId
     */
    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

}
