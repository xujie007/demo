package com.example.demo.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;

public class CommonUtils {


     /**
      * 配置千万条，集群第一条，环境不匹配，战友两行泪。 ——《流浪程序猿》
      * @Author 浮白
      * @Description //TODO
      * @Date 13:45 2019/4/29
      * @Param
      * @return
      **/
    public static RestResult commonResponse(String responseData){
        if(!StringUtils.isEmpty(responseData)){
            JSONObject data = JSONObject.parseObject(responseData);
            return RestResultGenerator.genResult(data);
        }
        return RestResultGenerator.genErrorResult(ErrorCode.SERVER_ERROR);
    }


     /**
      * 配置千万条，集群第一条，环境不匹配，战友两行泪。 ——《流浪程序猿》
      * @Author 浮白
      * @Description //TODO
      * @Date 13:50 2019/4/29
      * @Param
      * @return
      **/
    public static String getCompleteUrl(String incompleteUrl,ConfigUtils configUtils){
        if(!StringUtils.isEmpty(incompleteUrl)){
            incompleteUrl = MessageFormat.format(incompleteUrl, configUtils.getOrgName(), configUtils.getAppName());
            return incompleteUrl;
        }
        throw new NullPointerException();//临时使用该错误
    }




}
