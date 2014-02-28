/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.process.BeanWire;
import com.alipay.demo.bean.process.ProcessContext;

/**
 * �̻�����->֧�����̻�����������
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToProcessContext.java, v 0.1 2014-1-10 ����1:06:43 jie.hua Exp $
 */
public class ToProcessContext extends ProcessContext {

    /** ���к�ID */
    private static final long      serialVersionUID = -4855890717465632830L;

    /**
     * ֧����APIҵ������
     */
    private ToAlipayModelRequest   toAlipayModelRequest;

    /**
     * ֧����APIҵ������
     */
    private ToAlipayModelResponse  toAlipayModelReponse;

    /**
     * ֧����API����
     */
    private ToAlipayTargetRequest  toAlipayTargetRequest;

    /**
     * ֧����API��Ӧ
     */
    private ToAlipayTargetResponse toAlipayTargetResponse;

    /**
     * ˽�й��캯��
     */
    private ToProcessContext() {
    }

    /**
     * ��ȡ����ִ��������ʵ��
     * 
     * @return
     */
    public static ToProcessContext getInstance() {

        return new ToProcessContext();
    }

    /**
     * ����ʵ��
     * 
     * @param toAlipayModelRequest
     * @return
     */
    public ToProcessContext build(ToAlipayModelRequest toAlipayModelRequest) {

        this.setToAlipayModelRequest(toAlipayModelRequest);

        return this;
    }

    /** 
     * @see com.alipay.demo.bean.process.Instruction#getInstruction(java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends BeanWire> T getInstruction(Class<T> t) {

        if (ToAlipayModelRequest.class.isAssignableFrom(t)) {

            return (T) toAlipayModelRequest;
        } else if (t == ToAlipayTargetRequest.class) {

            return (T) toAlipayTargetRequest;
        } else if (t == ToAlipayTargetResponse.class) {

            return (T) toAlipayTargetResponse;
        } else if (t == ToAlipayModelResponse.class) {

            return (T) toAlipayModelReponse;
        } else if (t == ToProcessContext.class) {

            return (T) this;
        }

        return null;
    }

    /**
     * Setter method for property <tt>toAlipayModelRequest</tt>.
     * 
     * @param toAlipayModelRequest value to be assigned to property toAlipayModelRequest
     */
    public void setToAlipayModelRequest(ToAlipayModelRequest toAlipayModelRequest) {
        this.toAlipayModelRequest = toAlipayModelRequest;
    }

    /**
     * Setter method for property <tt>toAlipayTargetRequest</tt>.
     * 
     * @param toAlipayTargetRequest value to be assigned to property toAlipayTargetRequest
     */
    public void setToAlipayTargetRequest(ToAlipayTargetRequest toAlipayTargetRequest) {
        this.toAlipayTargetRequest = toAlipayTargetRequest;
    }

    /**
     * Setter method for property <tt>toAlipayTargetResponse</tt>.
     * 
     * @param toAlipayTargetResponse value to be assigned to property toAlipayTargetResponse
     */
    public void setToAlipayTargetResponse(ToAlipayTargetResponse toAlipayTargetResponse) {
        this.toAlipayTargetResponse = toAlipayTargetResponse;
    }

    /**
     * Setter method for property <tt>toAlipayModelReponse</tt>.
     * 
     * @param toAlipayModelReponse value to be assigned to property toAlipayModelReponse
     */
    public void setToAlipayModelReponse(ToAlipayModelResponse toAlipayModelReponse) {
        this.toAlipayModelReponse = toAlipayModelReponse;
    }

}
