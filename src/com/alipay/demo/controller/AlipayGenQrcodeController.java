/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *生成二维码控制执行器 
 *
 * @author jie.hua@alipay.com
 * @version $Id: AlipayGenQrcodeController.java, v 0.1 2014-3-1 下午6:14:30 jiehua Exp $
 */
@Controller
public class AlipayGenQrcodeController {

    /**
     * 二维码自定参数输入 
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

        String scenId = request.getParameter("scenId");

        if (StringUtils.isEmpty(scenId)) {

            model.addAttribute("result", Boolean.FALSE.booleanValue());
            model.addAttribute("resultMsg", "自定义参数不能为空!");

            return "genqrcode";
        }

        return "genqrcode";
    }

}
