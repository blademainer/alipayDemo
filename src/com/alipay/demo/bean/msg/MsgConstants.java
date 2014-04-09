/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.msg;

/**
 * ��Ϣ��س���
 * 
 * @author jie.hua@alipay.com
 * @version $Id: MsgConstants.java, v 0.1 2014-1-6 ����4:40:41 jie.hua Exp $
 */
public class MsgConstants {

    /**
     * �¼�����Ϣ
     */
    public static final String EVENT_MSG_TYPE              = "event";

    /**
     * �¼����
     */
    public static final String CLICK_EVENT_TYPE            = "click";

    /**
     * ��֤����
     */
    public static final String VERIFYGW_EVENT_TYPE         = "verifygw";

    /**
     * ��ע
     */
    public static final String FOLLOW_EVENT_TYPE           = "follow";

    /**
     * ȡ����ע
     */
    public static final String UNFOLLOW_EVENT_TYPE         = "unfollow";

    /**
     * ��ά��ɨ��
     * 
     */
    public static final String QR_SCAN_EVENT_TYPE          = "enter";

    /**
     * ���ⲿ������
     */
    public static final String AUTHENTICATION_ACTIONPARAMS = "authentication";

    /**
     * ɾ���ⲿ������
     */
    public static final String DELETE_BIND_ACTIONPARAMS    = "delete";

    /**
     * ͼ����Ϣ����
     */
    public static final String IMGTXT_MSG_TYPE             = "image-text";

    /**
     * �˵�key����
     * 
     * @author jie.hua@alipay.com
     * @version $Id: MsgConstants.java, v 0.1 2014-1-17 ����9:11:03 jie.hua Exp $
     */
    public static class MenuKeys {

        /**
         * ��ϢӦ��ʽ�˵�key:����ʾ��Ϣ
         */
        public static final String MENU_MSG_RESP      = "MSG_RESP";

        /**
         * ��ϢӦ��ʽ�˵�key:�û���Ϣ��Ϣ
         * 
         */
        public static final String MENU_MSG_OPEN_RESP = "MSG_OPEN_RESP";

    }

    /**
     * ��Ϣչʾ����
     * 
     * @author jie.hua@alipay.com
     * @version $Id: MsgConstants.java, v 0.1 2014-2-15 ����4:44:02 jiehua Exp $
     */
    public static class MsgShowType {

        /**
         * ������ʾ
         */
        public static final String SHOW_LEFT   = "show_left";

        /**
         * ֱ�Ӵ�
         */
        public static final String OPEN_DIRECT = "open_direct";

    }

    /**
     * ��Ϣ��Ȩ����
     * 
     * @author jie.hua@alipay.com
     * @version $Id: MsgConstants.java, v 0.1 2014-2-15 ����4:49:42 jiehua Exp $
     */
    public static class MsgAuthType {

        /**
         * �����Ϣ����
         */
        public static final String LOGIN_AUTH_TYPE = "loginAuth";
    }

}
