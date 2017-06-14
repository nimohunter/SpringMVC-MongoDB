package com.nimohunter.mvcdemo.MongoDB.userManager.model;

/**
 * Created by Nimo on 2017/5/19.
 * Contact me by nimohunter@gmail.com
 * Use for user regist
 */
public class NewUser {
    private String userName;
    private String userPwd;
    private String confirmPwd;

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean checkPassword() {
        return userPwd.equals(confirmPwd);
    }
}
