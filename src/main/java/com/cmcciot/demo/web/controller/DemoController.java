package com.cmcciot.demo.web.controller;

import com.cmcciot.demo.common.utils.ResponseUtil;
import com.cmcciot.demo.dao.model.User;
import com.cmcciot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Map;

/** MVC示例.
 * @Description
 * @Author 黄川
 * @Date 16/1/11
 */
@Controller
@RequestMapping("/")
public class DemoController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        return "index";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map getUserInfo(@PathVariable Integer id) {
        User user = userService.findById(id);

        return ResponseUtil.ok(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public Map getUsersInfo(int page, int size) {
        Map data = userService.findAllUsers(page, size);

        return ResponseUtil.ok(data);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@Valid User user) {
        System.out.println(user);
    }
}
