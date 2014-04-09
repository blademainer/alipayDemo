/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.msg;

/**
 * 消息相关常量
 * 
 * @author jie.hua@alipay.com
 * @version $Id: MsgConstants.java, v 0.1 2014-1-6 下午4:40:41 jie.hua Exp $
 */
public class MsgConstants {

    /**
     * 事件型消息
     */
    public static final String EVENT_MSG_TYPE              = "event";

    /**
     * 事件点击
     */
    public static final String CLICK_EVENT_TYPE            = "click";

    /**
     * 验证网关
     */
    public static final String VERIFYGW_EVENT_TYPE         = "verifygw";

    /**
     * 关注
     */
    public static final String FOLLOW_EVENT_TYPE           = "follow";

    /**
     * 取消关注
     */
    public static final String UNFOLLOW_EVENT_TYPE         = "unfollow";

    /**
     * 二维码扫码
     * 
     */
    public static final String QR_SCAN_EVENT_TYPE          = "enter";

    /**
     * 绑定外部户参数
     */
    public static final String AUTHENTICATION_ACTIONPARAMS = "authentication";

    /**
     * 删除外部户参数
     */
    public static final String DELETE_BIND_ACTIONPARAMS    = "delete";

    /**
     * 图文消息类型
     */
    public static final String IMGTXT_MSG_TYPE             = "image-text";

    /**
     * 菜单key常量
     * 
     * @author jie.hua@alipay.com
     * @version $Id: MsgConstants.java, v 0.1 2014-1-17 上午9:11:03 jie.hua Exp $
     */
    public static class MenuKeys {

        /**
         * 消息应答式菜单key:会显示消息
         */
        public static final String MENU_MSG_RESP      = "MSG_RESP";

        /**
         * 消息应答式菜单key:用户信息消息
         * 
         */
        public static final String MENU_MSG_OPEN_RESP = "MSG_OPEN_RESP";

    }

    /**
     * 消息展示类型
     * 
     * @author jie.hua@alipay.com
     * @version $Id: MsgConstants.java, v 0.1 2014-2-15 下午4:44:02 jiehua Exp $
     */
    public static class MsgShowType {

        /**
         * 靠左显示
         */
        public static final String SHOW_LEFT   = "show_left";

        /**
         * 直接打开
         */
        public static final String OPEN_DIRECT = "open_direct";

    }

    /**
     * 消息授权类型
     * 
     * @author jie.hua@alipay.com
     * @version $Id: MsgConstants.java, v 0.1 2014-2-15 下午4:49:42 jiehua Exp $
     */
    public static class MsgAuthType {

        /**
         * 免登信息共享
         */
        public static final String LOGIN_AUTH_TYPE = "loginAuth";
    }

}
