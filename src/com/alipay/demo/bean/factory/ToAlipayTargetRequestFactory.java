/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.factory;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alipay.demo.bean.ResultEnum;
import com.alipay.demo.bean.process.AlipayDemoException;
import com.alipay.demo.bean.to.ToAlipayModelRequest;
import com.alipay.demo.bean.to.ToAlipayTargetRequest;
import com.alipay.demo.response.converter.to.ToAlipayAddAccountRequestConverter;
import com.alipay.demo.response.converter.to.ToAlipayDefaultRequestConverter;
import com.alipay.demo.response.converter.to.ToAlipayDeleteAccountRequestConverter;
import com.alipay.demo.response.converter.to.ToAlipayGisGetRequestConverter;
import com.alipay.demo.response.converter.to.ToAlipayMenuCreateRequestConverter;
import com.alipay.demo.response.converter.to.ToAlipayMenuQueryRequestConverter;
import com.alipay.demo.response.converter.to.ToAlipayMenuUpdateRequestConverter;
import com.alipay.demo.response.converter.to.ToAlipayMsgPushRequestConverter;
import com.alipay.demo.response.converter.to.ToAlipayQueryAccountRequestConverter;
import com.alipay.demo.response.converter.to.ToAlipayRequestConverter;
import com.alipay.demo.response.converter.to.ToAlipayResetAccountRequestConverter;
import com.alipay.demo.response.converter.to.ToAlipaySystemTokenRequestConverter;
import com.alipay.demo.tools.LoggerUtil;

/**
 * 
 * �̻�->֧����ʵ�����󹤳�
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayTargetRequestFactory.java, v 0.1 2014-1-11 ����3:17:58 jie.hua Exp $
 */
public class ToAlipayTargetRequestFactory {

    /**
     * ��־
     */
    private static final Logger                                                               logger    = Logger
                                                                                                            .getLogger(ToAlipayTargetRequestFactory.class);

    /**
     * ת����ӳ��
     */
    private static final Map<Class<? extends ToAlipayModelRequest>, ToAlipayRequestConverter> cacheMaps = new HashMap<Class<? extends ToAlipayModelRequest>, ToAlipayRequestConverter>();

    /**
     * ��ʼ��ת����
     */
    static {

        registerConverter(new ToAlipayDefaultRequestConverter());
        registerConverter(new ToAlipayAddAccountRequestConverter());
        registerConverter(new ToAlipayMsgPushRequestConverter());
        registerConverter(new ToAlipaySystemTokenRequestConverter());
        registerConverter(new ToAlipayMenuQueryRequestConverter());
        registerConverter(new ToAlipayMenuUpdateRequestConverter());
        registerConverter(new ToAlipayMenuCreateRequestConverter());
        registerConverter(new ToAlipayResetAccountRequestConverter());
        registerConverter(new ToAlipayQueryAccountRequestConverter());
        registerConverter(new ToAlipayDeleteAccountRequestConverter());
        registerConverter(new ToAlipayGisGetRequestConverter());
    }

    /**
     * ע��ת����
     * 
     * @param converter
     */
    private static void registerConverter(ToAlipayRequestConverter converter) {

        cacheMaps.put(converter.getSrcClass(), converter);

    }

    /**
     * ��ȡת����
     * 
     * @param clz
     * @return
     */
    private static ToAlipayRequestConverter getConverter(Class<? extends ToAlipayModelRequest> clz) {

        ToAlipayRequestConverter converter = cacheMaps.get(clz);

        // ������ʵ����ת�����������Ĭ�ϻ���ת����
        if (converter == null) {

            converter = cacheMaps.get(ToAlipayModelRequest.class);
        }

        // �����������ܳ��쳣
        if (converter == null) {

            LoggerUtil.error(logger, "������[" + clz + "]�����ڶ�Ӧת����!");

            throw new AlipayDemoException(ResultEnum.NO_SUCH_CONVERTER.getResultCode(),
                String.format(ResultEnum.NO_SUCH_CONVERTER.getResultMsg(), clz.toString()));
        }

        return converter;

    }

    /**
     *  ҵ������->ʵ������
     * 
     * @param toAlipayModelRequest
     * @return
     */
    public static ToAlipayTargetRequest buildTargetReqFromModel(ToAlipayModelRequest toAlipayModelRequest) {

        return getConverter(toAlipayModelRequest.getClass()).convert(toAlipayModelRequest);

    }

}
