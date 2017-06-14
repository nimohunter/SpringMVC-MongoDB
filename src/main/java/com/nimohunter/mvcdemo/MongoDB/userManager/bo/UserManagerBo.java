package com.nimohunter.mvcdemo.MongoDB.userManager.bo;

/**
 * Created by nimohunter on 2017/6/14.
 * Contact me by nimohunter@gmail.com
 */
public interface UserManagerBo {
    boolean checkUserPassword(String userName, String password);
    boolean registerUser(String username, String password);
}
