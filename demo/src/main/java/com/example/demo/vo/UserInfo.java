package com.example.demo.vo;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserInfo extends AuthorizationInfo{

    @NotBlank(message = "用户名不能为空")
    String username;

    @NotBlank(message = "密码不能为空")
    @Size(min = 6,max = 12,message = "密码长度必须6-12位")
    String password;



}
