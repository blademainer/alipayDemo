/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alipay.demo.bean.to.AlipayQRCodeCreateInfo;
import com.alipay.demo.bean.to.AlipayQRCodeInfo;
import com.alipay.demo.bean.to.AlipayQRScene;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.bean.to.ToAlipayQRCodeCreateModelRequest;
import com.alipay.demo.bean.to.ToAlipayQRCodeCreateModelResponse;
import com.alipay.demo.bean.to.ToProcessContext;
import com.alipay.demo.process.ServiceEngine;

/**
 *���ɶ�ά�����ִ���� 
 *
 * @author jie.hua@alipay.com
 * @version $Id: AlipayGenQrcodeController.java, v 0.1 2014-3-1 ����6:14:30 jiehua Exp $
 */
@Controller
public class AlipayGenQrcodeController {

    /**  */
    private static final String SCEN_ID      = "scenId";

    /***/
    private static final String SHOW_LOGO    = "showLogo";

    /**  */
    private static final String RESULT_MSG   = "resultMsg";

    /**  */
    private static final String RESULT       = "result";

    /***/
    private static final String IMAGE_URL    = "imageUrl";

    private static final String EXPIRED_TIME = "expiredTime";

    /**
     * ����ִ������
     */
    @Autowired
    @Qualifier("toServiceEngine")
    private ServiceEngine       toServiceEngine;

    /**
     * ��ά���Զ��������� 
     * 
     * @return
     *
     */
    @RequestMapping(method = RequestMethod.GET, value = "genQrcode.do")
    public String doGet() {

        return "genqrcode";
    }

    /**
     * 
     * k
     * @param request
     * @param model
     * @return
     */

    @RequestMapping(method = RequestMethod.POST, value = "genQrcode.do")
    public String doGen(HttpServletRequest request, Model model) {

        String sceneId = request.getParameter(SCEN_ID);
        String showLogo = request.getParameter(SHOW_LOGO);

        if (StringUtils.isEmpty(sceneId)) {

            model.addAttribute("result", Boolean.FALSE.booleanValue());
            model.addAttribute("resultMsg", "�Զ����������Ϊ��!");

            return "genqrcode";
        }

        // 1.��װ����
        AlipayQRScene scene = new AlipayQRScene();
        scene.setSceneId(sceneId);

        AlipayQRCodeInfo codeInfo = new AlipayQRCodeInfo();
        codeInfo.setScene(scene);

        AlipayQRCodeCreateInfo createInfo = new AlipayQRCodeCreateInfo();
        createInfo.setShowLogo(StringUtils.isEmpty(showLogo) ? "N" : "Y");
        createInfo.setCodeInfo(codeInfo);

        ToAlipayQRCodeCreateModelRequest modelRequest = new ToAlipayQRCodeCreateModelRequest();
        modelRequest.setInfo(createInfo);

        ToProcessContext toProcessContext = ToProcessContext.getInstance().build(modelRequest);

        toServiceEngine.serviceProcess(toProcessContext);

        ToAlipayModelResponse modelResp = toProcessContext
            .getInstruction(ToAlipayModelResponse.class);

        model.addAttribute(RESULT, modelResp.isSuccess());
        model.addAttribute(RESULT_MSG, modelResp.getResultMsg());

        if (modelResp.isSuccess()) {

            ToAlipayQRCodeCreateModelResponse createModelResp = (ToAlipayQRCodeCreateModelResponse) modelResp;

            model.addAttribute(IMAGE_URL, createModelResp.getImageUrl());
            model.addAttribute(EXPIRED_TIME, createModelResp.getExpiredTime());

        }

        return "genqrcode";
    }

}
