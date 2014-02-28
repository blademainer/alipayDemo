/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.in;

import java.util.Date;

import org.apache.log4j.Logger;

import com.alipay.demo.bean.LoggerNames;
import com.alipay.demo.bean.factory.AlipayArticleMsgFactory;
import com.alipay.demo.bean.in.AlipayInArticleMsgResponse;
import com.alipay.demo.bean.in.AlipayInBizContent;
import com.alipay.demo.bean.in.AlipayInModelRequest;
import com.alipay.demo.bean.in.InProcessContext;
import com.alipay.demo.bean.msg.AlipayArticleItem;
import com.alipay.demo.bean.msg.AlipayArticleMsg;
import com.alipay.demo.bean.msg.MsgConstants;
import com.alipay.demo.bean.process.Instruction;
import com.alipay.demo.config.SystemConfig;
import com.alipay.demo.tools.LoggerUtil;
import com.alipay.demo.tools.ServiceTool;
import com.alipay.demo.tools.URLTool;

/**
 * 服务类型菜单响应执行器
 * <pre>
 *    返回消息会直接在支付宝客户端打开，而不会展示对应消息体
 * </pre>
 * 
 * @author jie.hua@alipay.com
 * @version $Id: InAlipayMenuOpenMsgExecutor.java, v 0.1 2014-2-15 下午4:40:47 jiehua Exp $
 */
public class InAlipayMenuOpenMsgExecutor extends InServiceExecutor {

    /**
     * 操作名称
     */
    private static final String OPERATION_NAME = "【支付宝点击菜单请求-打开消息】";

    /**
     * 日志
     */
    private static final Logger logger         = Logger.getLogger(LoggerNames.SERVICE_LOGGER);

    /** 
     * @see com.alipay.demo.process.ServiceExecutor#doAction(com.alipay.demo.bean.process.Instruction)
     */
    @Override
    public void doAction(Instruction instruction) {
        LoggerUtil.info(logger, OPERATION_NAME + ",开始执行菜单点击处理.");

        InProcessContext inProcessContext = instruction.getInstruction(InProcessContext.class);
        AlipayInModelRequest alipayInRequest = inProcessContext
            .getInstruction(AlipayInModelRequest.class);
        AlipayInBizContent alipayInBizContent = alipayInRequest.getAlipayInBizContent();

        // 1.申请绑定消息体
        // TODO 只是一种简单的文本响应方式，商户可以根据自身业务定制自己响应的响应方式
        AlipayArticleItem item = new AlipayArticleItem();
        item.setTitle("菜单响应-打开消息");
        item.setDesc(buildMsgDesc());
        item.setImageUrl("http://pic.alipayobjects.com/e/201311/1PaQ27Go6H_src.jpg");
        item.setUrl(URLTool.builderURL(SystemConfig.getHostUrl() + "/memberLogin.do", null));
        item.setAuthType(MsgConstants.MsgAuthType.LOGIN_AUTH_TYPE);
        item.setActionName("会员登录");

        // 2.申请绑定完整消息
        AlipayArticleMsg toAlipayArticleMsg = new AlipayArticleMsg();
        toAlipayArticleMsg.addItem(item);
        toAlipayArticleMsg.setAppId(alipayInBizContent.getAppId());
        toAlipayArticleMsg.setMsgType(MsgConstants.IMGTXT_MSG_TYPE);
        toAlipayArticleMsg.setCreateTime(new Date());
        toAlipayArticleMsg.setToUserId(alipayInBizContent.getFromUserId());
        toAlipayArticleMsg.setShowType(MsgConstants.MsgShowType.OPEN_DIRECT);

        // 3.申请绑定回复响应
        AlipayInArticleMsgResponse alipayInArticleMsgResponse = AlipayInArticleMsgResponse
            .getSuccessInstance();
        alipayInArticleMsgResponse.setAlipayArticleMsg(toAlipayArticleMsg);
        alipayInArticleMsgResponse
            .setMerchantMsg(AlipayArticleMsgFactory.toXml(toAlipayArticleMsg));

        inProcessContext.setAlipayInResponse(alipayInArticleMsgResponse);

        LoggerUtil.info(logger, OPERATION_NAME + ",执行菜单点击处理完毕.[alipayInArticleMsgResponse="
                                + alipayInArticleMsgResponse + "]");

    }

    /**
     * 构建消息响应
     * 
     * @return
     */
    private String buildMsgDesc() {

        StringBuilder msgBuilder = new StringBuilder(100);
        msgBuilder.append("这是一种菜单响应机制").append("\n").append("商户可以根据不同菜单响应不同的消息\n")
            .append("返回会直接打开消息体");

        return msgBuilder.toString();
    }

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return ServiceTool.buildInServiceName(MsgConstants.EVENT_MSG_TYPE,
            MsgConstants.CLICK_EVENT_TYPE, MsgConstants.MenuKeys.MENU_MSG_OPEN_RESP);
    }

}
