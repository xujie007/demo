package com.example.demo.util;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = {"classpath:easemob.properties"})
public class ConfigUtils {

    @Value("${orgName}")
    private String orgName;

    @Value("${appName}")
    private String appName;

    @Value("${easemobApi}")
    private String easemobApi;

    @Value("${clientId}")
    private String clientId;

    @Value("${clientSecret}")
    private String clientSecret;

    @Value("${token}")
    private String token;

    @Value("${registeredUser}")
    private String registeredUser;

    @Value("${sendMessages}")
    private String sendMessages;


}
