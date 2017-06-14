package com.nimohunter.mvcdemo.MongoDB.userManager.bo;

import com.nimohunter.mvcdemo.MongoDB.seq.dao.SequenceDao;
import com.nimohunter.mvcdemo.MongoDB.userManager.dao.UserManagerDao;
import com.nimohunter.mvcdemo.MongoDB.userManager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nimohunter on 2017/6/14.
 * Contact me by nimohunter@gmail.com
 */

@Service
public class UserManagerBoImpl implements UserManagerBo {

    private static final String USERMANAGER_SEQ_KEY = "User";

    @Autowired
    private SequenceDao sequenceDao;

    @Autowired
    private UserManagerDao userManagerDao;

    @Override
    public boolean checkUserPassword(String userName, String password) {
        boolean result = false;
        User user = userManagerDao.findUserByName(userName);
        if (user != null && user.getPassword().equals(password)) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean registerUser(String userName, String password) {

        User user = userManagerDao.findUserByName(userName);
        if (user != null) {
            return false;
        }

        user = new User();
        user.setId(sequenceDao.getNextSequenceId(USERMANAGER_SEQ_KEY));
        user.setName(userName);
        user.setPassword(password);
        userManagerDao.save(user);
        return true;
    }
}
