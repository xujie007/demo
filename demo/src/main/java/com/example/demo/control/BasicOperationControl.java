package com.example.demo.control;


import com.example.demo.service.BasicOperationService;
import com.example.demo.util.CommonUtils;
import com.example.demo.util.RestResult;
import com.example.demo.vo.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


 /**
  * 配置千万条，集群第一条，环境不匹配，战友两行泪。
  *                                      ——《流浪程序猿》
  * @Author 浮白
  * @className BasicOperationControl
  * @Description 基础操作
  * @Date 10:40 2019/4/29
  **/
@RestController
@RequestMapping(value = "/basicOperation")
public class BasicOperationControl {


    @Autowired
    private BasicOperationService basicOperationService;



     /**
      * 配置千万条，集群第一条，环境不匹配，战友两行泪。 ——《流浪程序猿》
      * @Author 浮白
      * @Description 发送文本消息（目前只支持对用户发送）
      * @Date 10:43 2019/4/29
      * @Param
      * @return
      **/
    @GetMapping(value = "/sendMessage")
    public RestResult sendMessage(@Validated SendMessage sendMessage){
        return CommonUtils.commonResponse(basicOperationService.sendMessage(sendMessage));
    }

}
