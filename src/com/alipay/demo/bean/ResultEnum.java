/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean;

/**
 * �����
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ResultEnum.java, v 0.1 2014-1-5 ����8:51:13 jie.hua Exp $
 */
public enum ResultEnum {

    /**
     * �ɹ�
     */
    SUCESS("200", "�ɹ�"),

    /**
     * ��ǩʧ��
     */
    SIGN_VERIFY_FAIL("300", "��ǩʧ��"),

    /**
     * ��ǩʧ��
     */
    SIGN_DO_FAIL("301", "��ǩʧ��"),

    /**
     * ִ����������
     */
    NO_SUCH_EXEUCTOR("500", "%s��Ӧִ����������"),

    /**
     * ת����������
     */
    NO_SUCH_CONVERTER("501", "%s��Ӧconverter������"),

    /**
     * ����֧����API�쳣
     */
    ALIPAY_EXP_EXECUTOR("550", "����֧����API�쳣"),

    /**
     * ϵͳ�쳣
     */
    SYSTEM_ERROR("8888", "ϵͳ�쳣");

    /**
     * ������
     */
    private String resultCode;

    /**
     * ��������
     */
    private String resultMsg;

    /**
     * 
     * @param resultCode
     * @param resultMsg
     */
    private ResultEnum(String resultCode, String resultMsg) {

        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    /**
     * Getter method for property <tt>resultCode</tt>.
     * 
     * @return property value of resultCode
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * Getter method for property <tt>resultMsg</tt>.
     * 
     * @return property value of resultMsg
     */
    public String getResultMsg() {
        return resultMsg;
    }

    /**
     * Setter method for property <tt>resultMsg</tt>.
     * 
     * @param resultMsg value to be assigned to property resultMsg
     */
    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

}
