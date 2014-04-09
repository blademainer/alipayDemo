/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.config;

import java.util.HashMap;
import java.util.Map;

/**
 * ֧������������
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayEnviromentType.java, v 0.1 2014-1-16 ����9:18:12 jie.hua Exp $
 */
public enum AlipayEnviromentType {

    /**
     * ֧����ɳ�价��
     */
    SANDBOX("SANDBOX", "֧����ɳ�价��"),

    /**
     * ֧�����ڲ�����
     */
    TEST("TEST", "֧�����ڲ����Ի���"),

    /**
     * ֧�����ڲ����Ի����� ���乫�ں�
     */
    SHAOQ_TEST("SHAOQ_TEST", "֧�����ڲ����Ի���-���乫�ں�"),

    /**
     * ֧�������ϻ���
     */
    ONLINE("ONLINE", "֧�������ϻ���");

    /**
     * ӳ���ϵ
     */
    private static final Map<String, AlipayEnviromentType> cachesMap = new HashMap<String, AlipayEnviromentType>();

    static {

        for (AlipayEnviromentType type : AlipayEnviromentType.values()) {

            cachesMap.put(type.getCode(), type);
        }

    }

    /**
     * ����
     */
    private String                                         code;

    /**
     * ����
     */
    private String                                         msg;

    /**
     * @param code
     * @param msg
     */
    private AlipayEnviromentType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * Getter method for property <tt>code</tt>.
     * 
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Getter method for property <tt>msg</tt>.
     * 
     * @return property value of msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * ���ݱ����ȡ����
     * 
     * @param code
     */
    public static AlipayEnviromentType getTypeByCode(String code) {

        return cachesMap.get(code);
    }

}
