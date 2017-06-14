package com.nimohunter.mvcdemo.controller;

import com.nimohunter.mvcdemo.MongoDB.userManager.model.NewUser;
import com.nimohunter.mvcdemo.service.login.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nimo on 2017/5/19.
 * Contact me by nimohunter@gmail.com
 */

@Controller
@RequestMapping("/user")
@Scope("prototype")
public class UserRegisterController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showLogin(HttpServletRequest request, HttpServletResponse response) {
        return "user_login/register";
    }


    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
                                @ModelAttribute("newUser") NewUser newUser) {
        if (newUser.checkPassword()) {
            boolean result = userService.register(newUser.getUserName(), newUser.getUserPwd());
            if (result) {
                return new ModelAndView("home");
            } else {
                request.setAttribute("message", "用户已存在");
                return new ModelAndView("user_login/error");
            }
        } else {
            request.setAttribute("message", "两次输入密码不一致");
            return new ModelAndView("user_login/error");
        }

    }
}
