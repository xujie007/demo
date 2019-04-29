package com.example.demo.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SendMessage extends AuthorizationInfo{

    @NotBlank(message = "发送信息不能为空")
    private String message;

    @NotBlank(message = "接收人名称不能为空")
    private String targetPerson;

    @NotNull(message = "发送对象类型不能为空")
    private Integer targetType;


    @NotBlank(message = "发送人名称不能为空")
    private String fromPerson;

    @NotNull(message = "信息类型不能为空")
    private Integer messageType;

}
