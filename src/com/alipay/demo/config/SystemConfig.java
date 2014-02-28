/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.config;

import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alipay.demo.process.in.InServiceEngine;
import com.alipay.demo.tools.LoggerUtil;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * ϵͳ���ó���
 * 
 * 
 * @author jie.hua@alipay.com
 * @version $Id: SystemConfig.java, v 0.1 2014-1-5 ����9:39:26 jie.hua Exp $
 */
public class SystemConfig {

    /**  */
    private static final String          HOST_URL       = "HOST_URL";

    /**
     * ��������
     */
    private static final String          OPERATION_NAME = "��ϵͳ���á�";

    /**
     * ��־
     */
    private static final Logger          logger         = Logger.getLogger(SystemConfig.class);

    /**
     * config��������
     */
    private Properties                   properties     = new Properties();

    /**
     * ����ӳ��
     */
    private Map<String, Config>          configMap      = new HashMap<String, Config>();

    /**
     * ������Ϣ����
     */
    private LoadingCache<String, String> typeCache      = CacheBuilder
                                                            .newBuilder()
                                                            .expireAfterAccess(5, TimeUnit.MINUTES)
                                                            .build(
                                                                new CacheLoader<String, String>() {

                                                                    @Override
                                                                    public String load(String key)
                                                                                                  throws Exception {

                                                                        return properties
                                                                            .getProperty(key);
                                                                    }

                                                                });

    /**
     * ����������Ϣ
     */
    private void loadProperties() {

        URL resource = InServiceEngine.class.getResource("/");

        // ��Դ�ļ�·��
        String path = resource.getPath().replace("/build/classes", "").replace("%20", " ")
            .replace("classes/", "")
                      + ("/config/config.properties").replaceFirst("/", "");

        // ������Դ
        try {
            properties.load(new FileReader(path));
        } catch (Exception e) {

            LoggerUtil.warn(logger, OPERATION_NAME + ",������Դ�����쳣", e);

        }

    }

    /**
     * ���뻺��ʵ��
     */
    private void loadCacheInstance() {

        configMap.put(AlipayEnviromentType.SANDBOX.getCode(), new SandboxConfig());
        configMap.put(AlipayEnviromentType.ONLINE.getCode(), new OnlineConfigNoCommit());
        configMap.put(AlipayEnviromentType.TEST.getCode(), new TestEnvConfig());

    }

    /**
     * ������
     */
    private SystemConfig() {

        loadCacheInstance();
        loadProperties();

    }

    /**
     * ��ȡ�����ļ�����
     * 
     * @param key
     * @return
     */
    private String getConfigValue(String key) {

        try {
            return typeCache.getUnchecked(key);
        } catch (Exception e) {

            LoggerUtil.warn(logger, OPERATION_NAME + ",��ѯ������Ϣ�쳣", e);

            return null;
        }
    }

    /**
     * ����ʵ��:ɳ������or��������
     * 
     * @return
     */
    private Config getConfig() {

        // ���������ļ��ڵ�ֵ����ѯ��������
        String enviroment = getConfigValue("enviromentType");

        if (StringUtils.isBlank(enviroment)) {

            enviroment = AlipayEnviromentType.ONLINE.getCode();
        }

        //���ݻ������ͷ��ض�Ӧ��������Ϣ
        return configMap.get(enviroment);

    }

    /**
     * ����holder
     * 
     * @author jie.hua@alipay.com
     * @version $Id: SystemConfig.java, v 0.1 2014-1-16 ����11:38:46 jie.hua Exp $
     */
    private static class SubIntanceHolder {

        public static final SystemConfig CONFIG_INSTANCE = new SystemConfig();

    }

    /**
     * ��ȡ��ǰʵ��
     * 
     * @return
     */
    private static SystemConfig getSystemConfigInstance() {

        return SystemConfig.SubIntanceHolder.CONFIG_INSTANCE;
    }

    /**
     * �����ʽ
     * <pre>
     *   ����ı����ʽ���̻���֧�������������Ӧ��ʱ�ĸ�ʽ��
     *   ֧����Ŀǰֻ֧��GBK��ʽ����������ı����ʽ�ǹ̶��ġ�
     * </pre>
     */
    private static final String CHARSET             = "GBK";

    /**
     * ֧�����ɹ�������
     */
    private static final String ALIPAY_SUCCESS_CODE = "200";

    /**
     * APP����
     */
    private static final String APP_NAME            = "APP_NAME";

    /**
     * ֧�����ַ���
     * 
     * @return
     */
    public static String getAlipayCharSet() {
        return CHARSET;
    }

    /**
     * ��ȡ֧�����ɹ���
     * 
     * @return
     */
    public static String getAlipaySuccessCode() {

        return ALIPAY_SUCCESS_CODE;
    }

    /**
     * ��ȡ������ַ
     * 
     * @return
     */
    public static String getHostUrl() {

        return getSystemConfigInstance().getConfigValue(HOST_URL) + "/"
               + getSystemConfigInstance().getConfigValue(APP_NAME);
    }

    /** 
     * @see com.alipay.demo.config.Config#getGateWay()
     */

    public static String getGateWay() {
        return getSystemConfigInstance().getConfig().getGateWay();
    }

    /** 
     * @see com.alipay.demo.config.Config#getPublicId()
     */

    public static String getPublicId() {
        return getSystemConfigInstance().getConfig().getPublicId();
    }

    /** 
     * @see com.alipay.demo.config.Config#getMerchantPublicKey()
     */

    public static String getMerchantPublicKey() {
        return getSystemConfigInstance().getConfig().getMerchantPublicKey();
    }

    /** 
     * @see com.alipay.demo.config.Config#getMerchantPrivateKey()
     */

    public static String getMerchantPrivateKey() {
        return getSystemConfigInstance().getConfig().getMerchantPrivateKey();
    }

    /** 
     * @see com.alipay.demo.config.Config#getAlipayPublicKey()
     */

    public static String getAlipayPublicKey() {
        return getSystemConfigInstance().getConfig().getAlipayPublicKey();
    }

    /** 
     * @see com.alipay.demo.config.Config#isCheckSign()
     */

    public static boolean isCheckSign() {
        return getSystemConfigInstance().getConfig().isCheckSign();
    }

    /** 
     * @see com.alipay.demo.config.Config#isDecrypt()
     */

    public static boolean isDecrypt() {
        return getSystemConfigInstance().getConfig().isDecrypt();
    }

    /** 
     * @see com.alipay.demo.config.Config#isSign()
     */

    public static boolean isSign() {
        return getSystemConfigInstance().getConfig().isSign();
    }

    /** 
     * @see com.alipay.demo.config.Config#isEncrypt()
     */

    public static boolean isEncrypt() {
        return getSystemConfigInstance().getConfig().isEncrypt();
    }

}
