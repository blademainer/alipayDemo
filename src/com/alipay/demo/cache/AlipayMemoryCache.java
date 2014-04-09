/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.cache;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * �ڴ�汾����ʵ��
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayCache.java, v 0.1 2014-1-8 ����10:13:18 jie.hua Exp $
 */
public class AlipayMemoryCache implements com.alipay.demo.cache.Cache {

    /**
     * cacheʵ��
     */
    private Cache<String, Object> cache;

    /**
     * ��������ʵ��
     * @param duration
     * @param timeUnit
     */
    public AlipayMemoryCache(long duration, TimeUnit timeUnit) {

        cache = CacheBuilder.newBuilder().expireAfterWrite(duration, timeUnit).maximumSize(10000)
            .build();
    }

    /**
     * ʵ��holder��
     * 
     * @author jie.hua@alipay.com
     * @version $Id: AlipayCache.java, v 0.1 2014-1-8 ����10:14:00 jie.hua Exp $
     */
    private static class CacheHolder {

        /**
         * ʱ����
         */
        private static final long             duration = 5;

        /**
         * ʱ�䵥λ
         */
        private static final TimeUnit         timeUnit = TimeUnit.MINUTES;

        /**
         * ʵ��
         */
        public static final AlipayMemoryCache instance = new AlipayMemoryCache(duration, timeUnit);
    }

    /**
     * ��ȡʵ��
     * 
     * @return
     */
    public static AlipayMemoryCache getInstance() {

        return AlipayMemoryCache.CacheHolder.instance;
    }

    /**
     * ���û���
     * 
     * @param key
     * @param value
     */
    @Override
    public void put(String key, Object value) {

        this.cache.put(key, value);

    }

    /**
     * ���ػ���ֵ
     * 
     * @param key
     * @return
     */
    @Override
    public Object get(String key) {

        if (StringUtils.isEmpty(key)) {

            return null;
        }

        return this.cache.getIfPresent(key);
    }

}
