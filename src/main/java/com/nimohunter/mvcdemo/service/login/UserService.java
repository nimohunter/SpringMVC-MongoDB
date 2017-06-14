package com.nimohunter.mvcdemo.service.login;


import org.springframework.stereotype.Service;

/**
 * Created by Nimo on 2017/5/18.
 * Contact me by nimohunter@gmail.com
 */

@Service
public interface UserService {
    boolean login(String username,String password);
    boolean register(String username,String password);

//    DeviceInfo getDeviceInfo(int developerId);
//    void saveDeviceInfo(DeviceInfo deviceInfo);
}
