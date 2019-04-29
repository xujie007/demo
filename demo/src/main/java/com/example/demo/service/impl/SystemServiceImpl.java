package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.SystemService;
import com.example.demo.util.*;
import com.example.demo.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.util.*;

@Service
public class SystemServiceImpl implements SystemService {


    @Autowired
    ConfigUtils configUtils;


    @Override
    public String getToken() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("grant_type","client_credentials");
        jsonObject.put("client_id",configUtils.getClientId());
        jsonObject.put("client_secret",configUtils.getClientSecret());
        String tokenUrl = configUtils.getToken();
        if(!StringUtils.isEmpty(tokenUrl)){
            tokenUrl = MessageFormat.format(tokenUrl, configUtils.getOrgName(), configUtils.getAppName());
        }
        return TokenUtils.getToken(jsonObject,tokenUrl);
    }

    @Override
    public String registeredUser(UserInfo userInfo) {
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("org_name",configUtils.getOrgName());
//        jsonObject.put("app_name",configUtils.getAppName());
//        jsonObject.put("Authorization","Bearer "+userInfo.getToken());
        String registeredUserUrl = configUtils.getRegisteredUser();
        if(!StringUtils.isEmpty(registeredUserUrl)){
            registeredUserUrl = MessageFormat.format(registeredUserUrl, configUtils.getOrgName(), configUtils.getAppName());
        }
        List<UserInfo> userInfos = new ArrayList<>();
        userInfos.add(userInfo);
        jsonObject.put("users",userInfos);
        //请求环信接口
        String responseData = HttpClientUtils.sendPostJson(registeredUserUrl,JSON.toJSONString(userInfos),configUtils.getToken());
        if(!StringUtils.isEmpty(responseData)){
            return responseData;
        }
        return null;
    }
}
