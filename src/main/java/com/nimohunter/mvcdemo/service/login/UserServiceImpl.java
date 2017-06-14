package com.nimohunter.mvcdemo.service.login;


import com.nimohunter.mvcdemo.MongoDB.userManager.bo.UserManagerBo;
import com.nimohunter.mvcdemo.MongoDB.userManager.dao.UserManagerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Nimo on 2017/5/18.
 * Contact me by nimohunter@gmail.com
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserManagerBo userManagerBo;

    @Override
    public boolean login(String username, String password) {
        return userManagerBo.checkUserPassword(username, password);
    }

    @Override
    public boolean register(String username, String password) {
        return userManagerBo.registerUser(username, password);
    }

}
