/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.in;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.alipay.demo.process.ServiceExecutor;

/**
 * ֧�������������湤��
 * 
 * @author jie.hua@alipay.com
 * @version $Id: InServiceExecutorFactory.java, v 0.1 2014-1-6 ����9:46:12 jie.hua Exp $
 */
public class InServiceExecutorFactory {

    /**
     * ����ӳ��
     */
    public Map<String, ServiceExecutor> executorMaps = new TreeMap<String, ServiceExecutor>(
                                                         new Comparator<String>() {

                                                             @Override
                                                             public int compare(String o1, String o2) {

                                                                 if (o1.length() > o2.length()) {

                                                                     return -1;
                                                                 } else if (o1.length() < o2
                                                                     .length()) {

                                                                     return 1;
                                                                 } else {

                                                                     int compare = o1.compareTo(o2);

                                                                     if (compare >= 0) {

                                                                         return -1;
                                                                     } else {

                                                                         return 1;
                                                                     }

                                                                 }

                                                             }
                                                         });

    /**
     * ����name��ѯ����ִ����
     * 
     * @param name
     * @return
     */
    public ServiceExecutor getExecutorByName(String name) {

        // 1.��ȷƥ��
        ServiceExecutor exactMatchExecutor = executorMaps.get(name);
        if (exactMatchExecutor != null) {

            return exactMatchExecutor;
        }

        // 2.������ʽƥ��,Խ��ƥ��Խ����
        for (Map.Entry<String, ServiceExecutor> executor : this.executorMaps.entrySet()) {

            if (name.matches(executor.getKey())) {
                return executor.getValue();
            }

        }

        return null;

    }

    /**
     *  ���÷���ִ����
     * 
     * @param executors
     */
    public void setExecutorList(List<InServiceExecutor> executors) {

        if (executors == null || executors.isEmpty()) {

            return;
        }

        for (InServiceExecutor executor : executors) {

            executorMaps.put(executor.getExecutorName(), executor);
        }

    }

}
