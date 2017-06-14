package com.nimohunter.mvcdemo.controller;

import com.nimohunter.mvcdemo.MongoDB.userManager.model.User;
import com.nimohunter.mvcdemo.service.FileDownload.Fileconfig;
import com.nimohunter.mvcdemo.service.ListFile.ListFileService;
import com.nimohunter.mvcdemo.service.login.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nimo on 2017/5/18.
 * Contact me by nimohunter@gmail.com
 */
//@Controller注解用于标示本类为web层控制组件
@Controller
//@RequestMapping("/user")用于标定访问时对url位置
@RequestMapping("/user")
//在默认情况下springmvc的实例都是单例模式,所以使用scope域将其注解为每次都创建一个新的实例
@Scope("prototype")
public class UserLoginController {

    Logger logger = LoggerFactory.getLogger(UserLoginController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(HttpServletRequest request, HttpServletResponse response) {
        return "user_login/login";
    }


    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public String login(User user, HttpServletRequest request) {
        //调用login方法来验证是否是注册用户
        logger.info("###############" + user.getName() + " | "+  user.getPassword());
        boolean loginType = userService.login(user.getName(), user.getPassword());
        if (loginType) {
            //如果验证通过,则将用户信息传到前台
            request.setAttribute("user", user);

            String uploadFilePath = Fileconfig.UPLOADFILELOCATION + user.getName();
            File file = new File(uploadFilePath);
            String resultPage = "";

            if (file.exists()) {
                Map<String, String> fileNameMap = new HashMap<String, String>();
                //递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中
                ListFileService.listfile(file, fileNameMap);//File既可以代表一个文件也可以代表一个目录
                //将Map集合发送到listfile.jsp页面进行显示
                request.setAttribute("fileNameMap", fileNameMap);
                //request.getRequestDispatcher("/listfile.jsp").forward(request, response);

                resultPage = "user_login/listfile";
            } else {
                resultPage = "user_login/welcome";
            }

            //并跳转到success.jsp页面
            return resultPage;
        } else {
            //若不对,则将错误信息显示到错误页面
            request.setAttribute("message", "用户名密码错误");
            return "user_login/error";
        }
    }


}
