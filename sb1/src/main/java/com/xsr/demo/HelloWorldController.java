package com.xsr.demo;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 145811 on 2018/3/23.
 */

@RestController
@RequestMapping(value = "/sb1")
public class HelloWorldController extends BaseController{

    public static final String DEFAULT_ERROR_VIEW = "error";

    @Autowired
    private BlogProperties blogProperties;

    @RequestMapping("/hello")
    public String index() {
        Assert.assertEquals(blogProperties.getName(), "祥先生");
        Assert.assertEquals(blogProperties.getTitle(), "Spring Boot教程");
        System.out.println(blogProperties.getDesc());
        return "Hello World";
    }


}
