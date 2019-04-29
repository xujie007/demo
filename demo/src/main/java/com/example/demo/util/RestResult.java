package com.example.demo.util;


 /**
  * 配置千万条，集群第一条，环境不匹配，战友两行泪。
  *                                      ——《流浪程序猿》
  * @Author 浮白
  * @className RestResult
  * @Description 返回实体
  * @Date 10:12 2019/4/28
  **/
public class RestResult<T> {

    private String code;
    private String message;
    private T data;

    private RestResult() {
        this(ErrorCode.NORMAL);
    }

    private RestResult(ErrorCode error) {
        code = error.getCode();
        message = error.getMessage();
    }

    protected static <T> RestResult<T> newInstance() {
        return new RestResult<>();
    }

    protected static <T> RestResult<T> newInstance(ErrorCode error) {
        return new RestResult<>(error);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RestResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }


}
