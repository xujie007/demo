package com.example.demo.util;

 /**
  * 配置千万条，集群第一条，环境不匹配，战友两行泪。
  *                                      ——《流浪程序猿》
  * @Author 浮白
  * @className JsonResponse
  * @Description //TODO
  * @Date 16:56 2019/4/25
  **/
public class JsonResponse {
	

	//错误码
	Integer code;
	//错误信息
	String message;
	//返回对象
	Object data;
	//序列号
	String serial;


	 public Integer getCode() {
		 return code;
	 }

	 public void setCode(Integer code) {
		 this.code = code;
	 }

	 public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}
}
