package com.sx.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * moayi
 *
 * @create 2018-06-01 14:18
 **/
@RestController
@Api(tags = "二：用户信息")
public class TestController {
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ApiOperation(value = "教程", httpMethod = "POST", notes = "教程")
    public  String getPth(@ApiParam(required = true, name = "test", value = "教程入参")String pa){
        return pa;
    }
}