package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.BasicOperationService;
import com.example.demo.util.CommonUtils;
import com.example.demo.util.ConfigUtils;
import com.example.demo.util.HttpClientUtils;
import com.example.demo.vo.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasicOperationServiceImpl implements BasicOperationService {

    @Autowired
    ConfigUtils configUtils;


    @Override
    public String sendMessage(SendMessage sendMessage) {
        JSONObject sendData = new JSONObject();
        String completeUrl = CommonUtils.getCompleteUrl(configUtils.getSendMessages(), configUtils);
        sendData.put("target_type","users");
        List<String> targetPerson = new ArrayList<>();
        targetPerson.add(sendMessage.getTargetPerson());
        JSONObject msg = new JSONObject();
        msg.put("type","txt");//临时使用
        msg.put("msg",sendMessage.getMessage());
        sendData.put("from",sendMessage.getFromPerson());//临时使用
        sendData.put("target",targetPerson);
        String responseData = HttpClientUtils.sendPostJson(completeUrl, JSON.toJSONString(sendData), sendMessage.getToken());
        return responseData;
    }
}
