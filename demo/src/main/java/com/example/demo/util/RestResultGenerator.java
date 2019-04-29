package com.example.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


 /**
  * 配置千万条，集群第一条，环境不匹配，战友两行泪。
  *                                      ——《流浪程序猿》
  * @Author 浮白
  * @className RestResultGenerator
  * @Description 服务器返回数据
  * @Date 10:13 2019/4/28
  **/
public class RestResultGenerator {


    private static final Logger LOGGER = LoggerFactory.getLogger(RestResultGenerator.class);



     /**
      * 配置千万条，集群第一条，环境不匹配，战友两行泪。 ——《流浪程序猿》
      * @Author 浮白
      * @Description 带数据的创建方法
      * @Date 10:13 2019/4/28
      * @Param data 返回数据
      * @return
      **/
    public static <T> RestResult<T> genResult(T data) {
        RestResult<T> result = RestResult.newInstance();
        result.setData(data);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("generate rest result:{}", result);
        }
        return result;
    }



     /**
      * 配置千万条，集群第一条，环境不匹配，战友两行泪。 ——《流浪程序猿》
      * @Author 浮白
      * @Description 无具体数据返回
      * @Date 10:14 2019/4/28
      * @Param
      * @return
      **/
    public static <T> RestResult<T> genSuccessResult() {
        return genResult(null);
    }



     /**
      * 配置千万条，集群第一条，环境不匹配，战友两行泪。 ——《流浪程序猿》
      * @Author 浮白
      * @Description 返回错误信息
      * @Date 10:15 2019/4/28
      * @Param message 提示信息
      * @return
      **/
    public static <T> RestResult<T> genErrorResult(String message) {
        RestResult<T> result = RestResult.newInstance();
        result.setCode(ErrorCode.SERVER_ERROR.getCode());
        result.setMessage(message);
        return result;
    }


     /**
      * 配置千万条，集群第一条，环境不匹配，战友两行泪。 ——《流浪程序猿》
      * @Author 浮白
      * @Description 服务器返回错误信息
      * @Date 10:15 2019/4/28
      * @Param message 错误信息
      * @return
      **/
    public static <T> RestResult<T> genServiceErrorResult(String message) {
        RestResult<T> result = RestResult.newInstance();
        result.setCode(ErrorCode.SERVER_ERROR.getCode());
        result.setMessage(message);
        return result;
    }

    public static <T> RestResult<T> genServiceResult(String code,String message) {
        RestResult<T> result = RestResult.newInstance();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }


     /**
      * 配置千万条，集群第一条，环境不匹配，战友两行泪。 ——《流浪程序猿》
      * @Author 浮白
      * @Description 返回错误信息，附带错误码
      * @Date 10:16 2019/4/28
      * @Param error 错误码
      * @return
      **/
    public static <T> RestResult<T> genErrorResult(ErrorCode error) {
        RestResult<T> result = RestResult.newInstance();
        result.setCode(error.getCode());
        result.setMessage(error.getMessage());
        return result;
    }


}
