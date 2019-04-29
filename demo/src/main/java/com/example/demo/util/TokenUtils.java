package com.example.demo.util;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
  * 配置千万条，集群第一条，环境不匹配，战友两行泪。
  *                                      ——《流浪程序猿》
  * @Author 浮白
  * @className TokenUtils
  * @Description 获取环信访问权限
  * @Date 16:20 2019/4/27
  **/
public class TokenUtils {


     /**
      * token获取之后，临时存放配置文件中，后期可以放入缓存
      * 放入配置文件，当前时间(System.currentTimeMillis)+过期时间(expires_in)，每次调用接口需要判断配置文件的时间是否小于当前时间
      * 如果小于当前时间，则需要重新获取token
      *
      * 如果放缓存，只需要设置缓存的过期时间，请求接口时从缓存读取，如果缓存不存在数据
      * 则需要重新获取token
      *
      */



      /**
       * 配置千万条，集群第一条，环境不匹配，战友两行泪。 ——《流浪程序猿》
       * @Author 浮白
       * @Description 获取token
       * @Date 16:56 2019/4/27
       * @Param
       * @return
       **/
     public static String getToken(JSONObject json,String url){
         //请求环信接口
         String responseData = HttpClientUtils.sendPostJson(url, json.toJSONString(),null);
         if(!StringUtils.isEmpty(responseData)){
             return responseData;
         }
         return null;
     }






}
