package com.nimohunter.mvcdemo.MongoDB.userManager.dao;

import com.nimohunter.mvcdemo.MongoDB.userManager.model.User;

/**
 * Created by nimohunter on 2017/6/14.
 * Contact me by nimohunter@gmail.com
 */
public interface UserManagerDao {
    void save(User user);
    User findUserByName(String name);
    void removeUserByName(String name);
}
