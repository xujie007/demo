package com.example.demo.vo;

import com.example.demo.annotation.TokenIsVaild;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AuthorizationInfo {


    @NotBlank(message = "授权秘钥不能为空")
    @TokenIsVaild(message = "token无效,请重新获取")
    String token;



}
