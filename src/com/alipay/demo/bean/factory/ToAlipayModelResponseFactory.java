/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.factory;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alipay.api.AlipayResponse;
import com.alipay.demo.bean.ResultEnum;
import com.alipay.demo.bean.process.AlipayDemoException;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.bean.to.ToAlipayTargetResponse;
import com.alipay.demo.response.converter.to.ToAlipayAddAccountResponseConverter;
import com.alipay.demo.response.converter.to.ToAlipayDefaultResponseConverter;
import com.alipay.demo.response.converter.to.ToAlipayDeleteAccountResponseConverter;
import com.alipay.demo.response.converter.to.ToAlipayGisGetResponseConverter;
import com.alipay.demo.response.converter.to.ToAlipayMenuQueryResponseConverter;
import com.alipay.demo.response.converter.to.ToAlipayQRCreateResponseConverter;
import com.alipay.demo.response.converter.to.ToAlipayQueryAccountResponseConverter;
import com.alipay.demo.response.converter.to.ToAlipayResetAccountResponseConverter;
import com.alipay.demo.response.converter.to.ToAlipayResponseConverter;
import com.alipay.demo.response.converter.to.ToAlipaySystemTokenResponseConverter;
import com.alipay.demo.tools.LoggerUtil;

/**
 * ����֧����ҵ��ģ�͹���
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayModelResponseFactory.java, v 0.1 2014-1-10 ����4:06:11 jie.hua Exp $
 */
public class ToAlipayModelResponseFactory {

    /**
     * ��־����
     */
    private static final Logger                                                    logger       = Logger
                                                                                                    .getLogger(ToAlipayModelResponseFactory.class);

    /**
     * ת����
     */
    private static Map<Class<? extends AlipayResponse>, ToAlipayResponseConverter> converterMap = new HashMap<Class<? extends AlipayResponse>, ToAlipayResponseConverter>();

    /**
     * ��ʼ��ת����
     */
    static {

        registerConverter(new ToAlipayAddAccountResponseConverter());
        registerConverter(new ToAlipayDefaultResponseConverter());
        registerConverter(new ToAlipaySystemTokenResponseConverter());
        registerConverter(new ToAlipayMenuQueryResponseConverter());
        registerConverter(new ToAlipayResetAccountResponseConverter());
        registerConverter(new ToAlipayQueryAccountResponseConverter());
        registerConverter(new ToAlipayGisGetResponseConverter());
        registerConverter(new ToAlipayQRCreateResponseConverter());
        registerConverter(new ToAlipayDeleteAccountResponseConverter());

    }

    /**
     * ע��ת����
     * 
     * @param toAlipayResponseConverter
     */
    private static void registerConverter(ToAlipayResponseConverter toAlipayResponseConverter) {

        converterMap.put(toAlipayResponseConverter.getSrcClass(), toAlipayResponseConverter);
    }

    /**
     * ��ȡת����
     * <pre>
     *  ���ݽ�����ͣ���ȡ��Ӧת�������������ڣ��򷵻�ToAlipayDefaultResponseConverter
     * </pre>
     * 
     * @param claz
     * @return
     */
    private static ToAlipayResponseConverter getConverter(Class<? extends AlipayResponse> clz) {

        ToAlipayResponseConverter converter = converterMap.get(clz);

        // �������򷵻�Ĭ��ת����
        if (converter == null) {

            converter = converterMap.get(AlipayResponse.class);
        }

        // �����������ܳ��쳣
        if (converter == null) {

            LoggerUtil.error(logger, "��Ӧ��[" + clz + "]�����ڶ�Ӧת����!");

            throw new AlipayDemoException(ResultEnum.NO_SUCH_CONVERTER.getResultCode(),
                String.format(ResultEnum.NO_SUCH_CONVERTER.getResultMsg(), clz.toString()));
        }

        return converter;
    }

    /**
     * ����ҵ����Ӧ
     * 
     * @param toAlipayTargetResponse
     * @return
     */
    public static ToAlipayModelResponse buildModelRespFromTarget(ToAlipayTargetResponse toAlipayTargetResponse) {

        if (toAlipayTargetResponse == null || toAlipayTargetResponse.getAlipayResponse() == null) {

            return buildFailResponse(ResultEnum.SYSTEM_ERROR.getResultCode(),
                ResultEnum.SYSTEM_ERROR.getResultMsg());

        } else {

            AlipayResponse alipayResponse = toAlipayTargetResponse.getAlipayResponse();

            // ���ݲ�ͬ��API Name ת���ɲ�ͬ��model response
            ToAlipayResponseConverter converter = getConverter(alipayResponse.getClass());

            return converter.convert(alipayResponse);

        }

    }

    /**
     * ����һ��ʧ�ܵĽ��
     * 
     * @param resultCode
     * @param resultMsg
     * @return
     */
    public static ToAlipayModelResponse buildFailResponse(String resultCode, String resultMsg) {

        ToAlipayModelResponse alipayModelReponseParam = new ToAlipayModelResponse(resultCode,
            resultMsg);
        alipayModelReponseParam.setSuccess(false);

        return alipayModelReponseParam;

    }

}
