package com.example.demo.util;


 /**
  * 配置千万条，集群第一条，环境不匹配，战友两行泪。
  *                                      ——《流浪程序猿》
  * @Author 浮白
  * @className ErrorCode
  * @Description 错误码
  * @Date 10:12 2019/4/28
  **/
public enum ErrorCode {

    NORMAL("0000", "server is ok"),
    ILLEGAL_PARAMS("0100", "request params invalid"),
    SERVER_ERROR("0200", "server is busy");

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;

    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


}
