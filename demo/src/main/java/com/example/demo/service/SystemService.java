package com.example.demo.service;

import com.example.demo.vo.UserInfo;

public interface SystemService {
    String getToken();

    String registeredUser(UserInfo userInfo);
}
