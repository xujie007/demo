package com.example.demo.aop;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Aspect
@Component
public class TokenAop {


    @Pointcut("execution(public * com.example.demo.control.TestControl.*(..))")
    public void addAdvice(){}

    @Around("addAdvice()")
    public Object Interceptor(ProceedingJoinPoint proceedingJoinPoint){
        Object result = null;
        Object[] args = proceedingJoinPoint.getArgs();
        JSONObject jsonObject = new JSONObject();
        if(args != null && args.length >0) {
            //判断token
//            for (Object object:args) {
//                String string = String.valueOf(object);
//                String[] split = string.split("=");
//                jsonObject.put(split[0],split[1]);
//            }
            if(StringUtils.isEmpty(jsonObject.getString("token"))){
                return "token is null";
            }
//            return "token is null";
//            String deviceId = (String) args[0];
//            if(!"03".equals(deviceId)) {
//                return "no anthorization";
//            }
        }
        try {
            result =proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }


}
