package com.example.demo.vo;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class TestVO {


    @NotEmpty(message = "名称不能为空")
    @Size(min = 1,max = 12,message = "名称长度不合法")
    private String name;


    @Email
    @NotEmpty(message = "Email不能为空")
    private String email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
