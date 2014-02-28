/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter.to;

import com.alipay.api.AlipayResponse;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.demo.bean.ResultEnum;
import com.alipay.demo.bean.factory.AlipayErrorCodeFactory;
import com.alipay.demo.bean.to.AlipayAccessTokenInfo;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.bean.to.ToAlipayTokenModelResponse;

/**
 * ֧������Ȩ����Ӧת����
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipaySystemTokenResponseConverter.java, v 0.1 2014-2-20 ����3:56:34 jiehua Exp $
 */
public class ToAlipaySystemTokenResponseConverter extends ToAlipayResponseConverter {

    /** 
     * @see com.alipay.demo.response.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ToAlipayModelResponse convert(AlipayResponse srcObj) {

        // 1.֧�������ؽ��
        AlipaySystemOauthTokenResponse tokenResponse = (AlipaySystemOauthTokenResponse) srcObj;

        // 2.ת����ҵ����
        if (tokenResponse == null) {

            return new ToAlipayTokenModelResponse(ResultEnum.SUCESS.getResultCode(),
                ResultEnum.SUCESS.getResultMsg());

        } else if (tokenResponse != null && tokenResponse.isSuccess()) {

            // 2.1 ��Ϣת��
            AlipayAccessTokenInfo accessCodeInfo = new AlipayAccessTokenInfo();
            accessCodeInfo.setAccessToken(tokenResponse.getAccessToken());
            accessCodeInfo.setAlipayUserId(tokenResponse.getAlipayUserId());
            accessCodeInfo.setExpireIn(tokenResponse.getExpiresIn());

            ToAlipayTokenModelResponse alipayTokenModelResponse = new ToAlipayTokenModelResponse(
                ResultEnum.SUCESS.getResultCode(), ResultEnum.SUCESS.getResultMsg());

            alipayTokenModelResponse.setAlipayAccessTokenInfo(accessCodeInfo);

            return alipayTokenModelResponse;

        } else {

            // 3.1ʧ������£�ת�������
            ResultEnum modelResult = AlipayErrorCodeFactory.convertFromAlipayResponse(
                tokenResponse.getErrorCode(), tokenResponse.getMsg());

            ToAlipayTokenModelResponse alipayTokenModelResponse = new ToAlipayTokenModelResponse(
                modelResult.getResultCode(), modelResult.getResultMsg());

            return alipayTokenModelResponse;

        }

    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayResponseConverter#getSrcClass()
     */
    @Override
    public Class<? extends AlipayResponse> getSrcClass() {
        return AlipaySystemOauthTokenResponse.class;
    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayResponseConverter#getTargetClass()
     */
    @Override
    public Class<? extends ToAlipayModelResponse> getTargetClass() {
        return ToAlipayTokenModelResponse.class;
    }

}
