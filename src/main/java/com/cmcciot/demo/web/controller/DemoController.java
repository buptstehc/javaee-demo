package com.cmcciot.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description
 * @Author 黄川
 * @Date 16/1/11
 */
@Controller
@RequestMapping("/")
public class DemoController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        return "index";
    }
}
