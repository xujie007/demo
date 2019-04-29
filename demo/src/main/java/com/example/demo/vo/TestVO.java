package com.example.demo.vo;


import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ToString
@Data
public class TestVO extends AuthorizationInfo{


    @NotEmpty(message = "名称不能为空")
    @Size(min = 1,max = 12,message = "名称长度不合法")
    private String name;


    @Email
    @NotEmpty(message = "Email不能为空")
    private String email;

}
