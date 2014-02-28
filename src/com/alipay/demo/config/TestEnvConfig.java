/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.config;

import com.alipay.demo.bean.ToStringBase;

/**
 * ֧�����ڲ���������
 * 
 * @author jie.hua@alipay.com
 * @version $Id: TestEnvConfig.java, v 0.1 2014-2-17 ����7:53:36 jiehua Exp $
 */
public class TestEnvConfig extends ToStringBase implements Config {

    /** ���к� */
    private static final long serialVersionUID = -7513098302751403656L;

    /** 
     * @see com.alipay.demo.config.Config#getGateWay()
     */
    @Override
    public String getGateWay() {
        return "http://openapi-1-64.test.alipay.net/gateway.do";
    }

    /** 
     * @see com.alipay.demo.config.Config#getPublicId()
     */
    @Override
    public String getPublicId() {
        return "2013122100013439";
    }

    /** 
     * @see com.alipay.demo.config.Config#getMerchantPublicKey()
     */
    @Override
    public String getMerchantPublicKey() {
        return "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCitD16CypwZILTpdJL8nPV9rVFHYf5UWa/URNX6469mbQLpWfjKM/VSWRXsNVGSM3itOO/KG2Pw4x5g9xjH6iaE4LlaidjBIPpifISSlnpbyi4HxQTZYgMPv/TuiWofUN5kcwg/KQAQxB2OwTOeFu2i3LhqSCDmv6koTvHW15/hQIDAQAB";
    }

    /** 
     * @see com.alipay.demo.config.Config#getMerchantPrivateKey()
     */
    @Override
    public String getMerchantPrivateKey() {

        return "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKK0PXoLKnBkgtOl0kvyc9X2tUUdh/lRZr9RE1frjr2ZtAulZ+Moz9VJZFew1UZIzeK0478obY/DjHmD3GMfqJoTguVqJ2MEg+mJ8hJKWelvKLgfFBNliAw+/9O6Jah9Q3mRzCD8pABDEHY7BM54W7aLcuGpIIOa/qShO8dbXn+FAgMBAAECgYA8+nQ380taiDEIBZPFZv7G6AmT97doV3u8pDQttVjv8lUqMDm5RyhtdW4n91xXVR3ko4rfr9UwFkflmufUNp9HU9bHIVQS+HWLsPv9GypdTSNNp+nDn4JExUtAakJxZmGhCu/WjHIUzCoBCn6viernVC2L37NL1N4zrR73lSCk2QJBAPb/UOmtSx+PnA/mimqnFMMP3SX6cQmnynz9+63JlLjXD8rowRD2Z03U41Qfy+RED3yANZXCrE1V6vghYVmASYsCQQCoomZpeNxAKuUJZp+VaWi4WQeMW1KCK3aljaKLMZ57yb5Bsu+P3odyBk1AvYIPvdajAJiiikRdIDmi58dqfN0vAkEAjFX8LwjbCg+aaB5gvsA3t6ynxhBJcWb4UZQtD0zdRzhKLMuaBn05rKssjnuSaRuSgPaHe5OkOjx6yIiOuz98iQJAXIDpSMYhm5lsFiITPDScWzOLLnUR55HL/biaB1zqoODj2so7G2JoTiYiznamF9h9GuFC2TablbINq80U2NcxxQJBAMhw06Ha/U7qTjtAmr2qAuWSWvHU4ANu2h0RxYlKTpmWgO0f47jCOQhdC3T/RK7f38c7q8uPyi35eZ7S1e/PznY=";

    }

    /** 
     * @see com.alipay.demo.config.Config#getAlipayPublicKey()
     */
    @Override
    public String getAlipayPublicKey() {

        return "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";
    }

    /** 
     * @see com.alipay.demo.config.Config#isCheckSign()
     */
    @Override
    public boolean isCheckSign() {
        return true;
    }

    /** 
     * @see com.alipay.demo.config.Config#isDecrypt()
     */
    @Override
    public boolean isDecrypt() {
        return false;
    }

    /** 
     * @see com.alipay.demo.config.Config#isSign()
     */
    @Override
    public boolean isSign() {
        return true;
    }

    /** 
     * @see com.alipay.demo.config.Config#isEncrypt()
     */
    @Override
    public boolean isEncrypt() {
        return false;
    }

}
