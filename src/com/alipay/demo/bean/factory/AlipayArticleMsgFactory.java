/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.factory;

import com.alipay.demo.bean.msg.AlipayArticleItem;
import com.alipay.demo.bean.msg.AlipayArticleMsg;
import com.alipay.xml.AdvanceXStream;
import com.alipay.xml.converter.AlipayInUserInfoConverter;
import com.alipay.xml.converter.DateLongFormatConverter;
import com.alipay.xml.converter.JavaObjectConverter;

/**
 * ֧����article��Ϣ���͹�����
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayArticleMsgFactory.java, v 0.1 2014-1-6 ����3:43:01 jie.hua Exp $
 */
public class AlipayArticleMsgFactory {

    /**
     * xml������
     */
    private static AdvanceXStream advanceXStream = new AdvanceXStream();

    static {

        advanceXStream.registerConverter(new JavaObjectConverter());
        advanceXStream.registerConverter(new DateLongFormatConverter());
        advanceXStream.registerConverter(new AlipayInUserInfoConverter());

        advanceXStream.registerParserClass(AlipayArticleMsg.class, AlipayArticleItem.class);
    }

    /**
     * ��Ϣ��ת����XML��ʽ�ַ���
     * 
     * @param toAlipayArticleMsg
     * @return
     */
    public static String toXml(AlipayArticleMsg toAlipayArticleMsg) {

        return advanceXStream.toXml(toAlipayArticleMsg);
    }

    /**
     * ��Ϣ��XMLת���ɶ���
     * 
     * @param xml
     * @return
     */
    public static AlipayArticleMsg fromXml(String xml) {

        return (AlipayArticleMsg) advanceXStream.fromXml(xml);
    }

}
