package com.example.demo.util;

import lombok.Data;

/**
  * 配置千万条，集群第一条，环境不匹配，战友两行泪。
  *                                      ——《流浪程序猿》
  * @Author 浮白
  * @className JsonResponse
  * @Description //TODO
  * @Date 16:56 2019/4/25
  **/
@Data
public class JsonResponse<T> {
	

	//错误码
	Integer code;
	//错误信息
	String message;
	//返回对象
	Object data;
	//序列号
	String serial;

}
