package com.example.demo.control;


import com.example.demo.util.ConfigUtils;
import com.example.demo.util.JsonResponse;
import com.example.demo.vo.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestControl {


    @Autowired
    private ConfigUtils configUtils;


    @RequestMapping(value = "/testM", method = RequestMethod.GET)
    public JsonResponse testM(@Validated TestVO vo) {
        JsonResponse okResult = new JsonResponse ();
        okResult.setCode(200);
        okResult.setMessage(vo.toString());
        return okResult;
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String test2(String name){
        String orgName = configUtils.getOrgName();
        String appName = configUtils.getOrgName();
        System.out.println(appName);
        //测试读取配置文件的，功能是否可以实现。
        return orgName;
    }

}
