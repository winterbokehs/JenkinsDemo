package com.example.demo.controller;

import com.example.demo.config.DemoThreadHost;
import com.example.demo.pojo.LoginUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "获取登录用户信息controller")
@RestController
@RequestMapping("/api")
public class DemoController {
    @Autowired
    private DemoThreadHost host;


    @ApiOperation(value = "德莫", response = LoginUser.class)
    @GetMapping("demo")
    public String demo(){
        return host.getUser().getName()+"-->你好";
    }

}
