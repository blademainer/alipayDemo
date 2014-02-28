/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.factory;

import com.alipay.demo.bean.AlipayAuthKeys;
import com.alipay.demo.bean.in.AlipayInAuthInfo;
import com.alipay.demo.bean.in.AlipayInTargetRequest;

/**
 * 支付宝用户授权信息构建工厂
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayInAuthInfoFactory.java, v 0.1 2014-2-15 下午5:23:55 jiehua Exp $
 */
public class AlipayInAuthInfoFactory {

    /**
     * 构建授权信息
     * 
     * @param request
     * @return
     */
    public static AlipayInAuthInfo buildInfo(AlipayInTargetRequest request) {

        AlipayInAuthInfo alipayInAuthInfo = new AlipayInAuthInfo();

        alipayInAuthInfo.setAlipayAuth(request.getRequestParams().get(AlipayAuthKeys.ALIPAY_AUTH));

        alipayInAuthInfo.setAppId(request.getRequestParams().get(AlipayAuthKeys.APP_ID));

        alipayInAuthInfo.setAuthCode(request.getRequestParams().get(AlipayAuthKeys.AUTH_CODE));

        alipayInAuthInfo.setPublicId(request.getRequestParams().get(AlipayAuthKeys.PUBLIC_ID));

        alipayInAuthInfo.setAlipayUserId(request.getRequestParams().get(
            AlipayAuthKeys.ALIPAY_USER_ID));

        alipayInAuthInfo.setSourceId(request.getRequestParams().get(AlipayAuthKeys.SOURCE_ID));

        return alipayInAuthInfo;

    }

}
