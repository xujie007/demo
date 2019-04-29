package com.example.demo.control;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.SystemService;
import com.example.demo.util.ErrorCode;
import com.example.demo.util.JsonResponse;
import com.example.demo.util.RestResult;
import com.example.demo.util.RestResultGenerator;
import com.example.demo.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 /**
  * 配置千万条，集群第一条，环境不匹配，战友两行泪。
  *                                      ——《流浪程序猿》
  * @Author 浮白
  * @className SystemControl
  * @Description 系统接口
  * @Date 16:51 2019/4/27
  **/
@RestController
@RequestMapping(value = "/system")
public class SystemControl {


    @Autowired
    private SystemService systemService;


     /**
      * 配置千万条，集群第一条，环境不匹配，战友两行泪。 ——《流浪程序猿》
      * @Author 浮白
      * @Description 获取token
      * @Date 16:52 2019/4/27
      * @Param
      * @return
      **/
    @GetMapping(value = "/getToken")
    public RestResult getToken(){
        String responseData = systemService.getToken();
        //1.将token放入缓存设置缓存过期时间（暂时不用这种方式）
        //2.直接将token过期时间写入配置文件
        if(!StringUtils.isEmpty(responseData)){
            JSONObject data = JSONObject.parseObject(responseData);
            return RestResultGenerator.genResult(data);
        }
        return RestResultGenerator.genErrorResult(ErrorCode.SERVER_ERROR);
    }


     /**
      * 配置千万条，集群第一条，环境不匹配，战友两行泪。 ——《流浪程序猿》
      * @Author 浮白
      * @Description 注册用户(需要改成可以批量注册的)
      * @Date 14:22 2019/4/28
      * @Param userInfo 注册用户信息
      * @return
      **/
    @GetMapping(value = "/registeredUser")
    public RestResult registeredUser(@Validated UserInfo userInfo){
        String responseData = systemService.registeredUser(userInfo);
        if(!StringUtils.isEmpty(responseData)){
            JSONObject data = JSONObject.parseObject(responseData);
            return RestResultGenerator.genResult(data);
        }
        return RestResultGenerator.genErrorResult(ErrorCode.SERVER_ERROR);
    }








 }
