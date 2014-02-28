/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean;

/**
 * 
 * 支付宝与商户之间交互的所有API名称
 * <pre>
 *   使用支付宝SDK，已经无需关系支付宝相关的API名称了，
 *   只需要直接调用SDK内部对应的请求Bean即可
 * </pre>
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayAPINames.java, v 0.1 2014-1-10 上午9:09:57 jie.hua Exp $
 */
public class AlipayAPINames {

    /**
     * 支付宝请求商户的统一API
     */
    public static final String ALIPAY_TO_MERCHANT_API        = "alipay.mobile.public.message.notify";

    /**
     * 支付宝账户绑定回调API
     */
    public static final String ALIPAY_ADD_ACCOUNT_API        = "alipay.mobile.public.account.add";

    /**
     * 支付宝账户删除API
     */
    public static final String ALIPAY_DELETE_ACCOUNT_API     = "alipay.mobile.public.account.delete";

    /**
     * 支付宝账户重置API
     */
    public static final String ALIPAY_RESET_ACCOUNT_API      = "alipay.mobile.public.account.reset";

    /**
     * 支付宝账户查询API
     */
    public static final String ALIPAY_QUERY_ACCOUNT_API      = "alipay.mobile.public.account.query";

    /**
     * 支付宝推送用户消息API
     */
    public static final String ALIPAY_MSG_PUSH_API           = "alipay.mobile.public.message.push";

    /**
     * 支付宝授权码换取API
     */
    public static final String ALIPAY_SYSTEM_OAUTH_TOKEN_API = "alipay.system.oauth.token";

    /**
     * 菜单查询API
     */
    public static final String ALIPAY_MENU_GET_API           = "alipay.mobile.public.menu.get";

    /**
     * 菜单创建API
     */
    public static final String ALIPAY_MENU_ADD_API           = "alipay.mobile.public.menu.add";

    /**
     * 菜单更新API
     */
    public static final String ALIPAY_MENU_UPDATE_API        = "alipay.mobile.public.menu.update";

    /**
     * 用户地理位置信息获取
     */
    public static final String ALIPAY_GIS_GET_API            = "alipay.mobile.public.gis.get";

}
