package com.xsr.web;

import com.xsr.config.BlogProperties;
import com.xsr.aop.AccessLogOpt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by 145811 on 2018/3/23.
 */

@RestController
@RequestMapping(value = "/sb1")
@Api("swaggerDemoController相关的api")
public class HelloWorldController extends BaseController {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @Autowired
    private BlogProperties blogProperties;

    @RequestMapping(value = "/helloJson", method = RequestMethod.POST)
    public String helloJson() {
//        Assert.assertEquals(blogProperties.getName(), "祥先生");
//        Assert.assertEquals(blogProperties.getTitle(), "Spring Boot教程");
//        System.out.println(blogProperties.getDesc());
        if (1 == 1) {
//            throw new RuntimeException("");
        }

        return "Hello World";
    }

    @AccessLogOpt
    @RequestMapping("/helloHtml")
    public String helloHtml() {
        Assert.assertEquals(blogProperties.getName(), "祥先生");
        Assert.assertEquals(blogProperties.getTitle(), "Spring Boot教程");
        System.out.println(blogProperties.getDesc());
        return "Hello World";
    }

    @RequestMapping(value = "/helloTime", method = RequestMethod.POST)
    @ApiOperation(value = "根据id查询学生信息", notes = "查询数据库中某个的学生信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Date", name = "dt1", value = "信息id", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "Date", name = "dt2", value = "信息id", required = true)})
    public Date helloTime(@RequestParam(value = "dt1", required = false) Date dt1, @RequestParam(value = "dt2", required = false) Date dt2) {

//        Assert.assertEquals(blogProperties.getName(), "祥先生");
//        Assert.assertEquals(blogProperties.getTitle(), "Spring Boot教程");
//        System.out.println(blogProperties.getDesc());
        if (1 == 1) {
//            throw new RuntimeException("");
        }

        return dt2;
    }

}
