package com.example.demo.annotation;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TokenIsVaildValidator implements ConstraintValidator<TokenIsVaild,String> {



    @Override
    public void initialize(TokenIsVaild constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //校验token是否过期
        if(!StringUtils.isEmpty(s)){
            //第一种方法这里直接从缓存获取token,如果不存在，说明token已经失效
            //TODO
            //第二种方法直接读取配置文件过期时间，然后和当前时间比较大小，如果小于当前时间，则token失效
            //TODO
            return true;

//            return false;
        }
        return false;
    }
}
