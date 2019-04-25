package com.example.demo.hanlder;


import com.example.demo.util.JsonResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class BindExceptionHanlder {

    @ExceptionHandler(BindException.class)
    public JsonResponse handleBindException(BindException ex) {
        // ex.getFieldError():随机返回一个对象属性的异常信息。如果要一次性返回所有对象属性异常信息，则调用ex.getAllErrors()
        StringBuilder sb = new StringBuilder();
        List<ObjectError> allErrors = ex.getAllErrors();
        for(ObjectError error : allErrors){
           sb.append(error.getDefaultMessage()+",");
        }
//        FieldError fieldError = ex.getFieldError();
//        sb.append(fieldError.getField()).append("=[").append(fieldError.getRejectedValue()).append("]")
//                .append(fieldError.getDefaultMessage());
        // 生成返回结果
        JsonResponse errorResult = new JsonResponse();
        errorResult.setCode(400);
        errorResult.setMessage(sb.toString());
        return errorResult;
    }




}
