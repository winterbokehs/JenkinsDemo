package com.example.demo.controller;

import com.example.demo.Utils.HttpURLConnectionUtil;
import com.example.demo.config.DemoThreadHost;
import com.example.demo.pojo.LoginUser;
import com.example.demo.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api")
@Api(value = "获取JSON的Controller")
public class JSONCreateController {
    @Autowired
    private DemoThreadHost host;


    @ApiOperation(value = "getJSON", response = String.class)
    @GetMapping("/getJSON")
    public String demo(){
        String json = "[\n" +
                "\n" +
                "  {\n" +
                "\n" +
                "    \"name\":\"张国立\",\n" +
                "\n" +
                "    \"sex\":\"男\",\n" +
                "\n" +
                "    \"email\":\"zhangguoli@123.com\",\n" +
                "\n" +
                "    \"url\":\"./img/1.jpg\"\n" +
                "\n" +
                "  },\n" +
                "\n" +
                "  {\n" +
                "\n" +
                "    \"name\":\"张铁林\",\n" +
                "\n" +
                "    \"sex\":\"男\",\n" +
                "\n" +
                "    \"email\":\"zhangtieli@123.com\",\n" +
                "\n" +
                "    \"url\":\"./img/2.jpg\"\n" +
                "\n" +
                "  },\n" +
                "\n" +
                "  {\n" +
                "\n" +
                "    \"name\":\"邓婕\",\n" +
                "\n" +
                "    \"sex\":\"女\",\n" +
                "\n" +
                "    \"email\":\"zhenjie@123.com\",\n" +
                "\n" +
                "    \"url\":\"./img/3.jpg\"\n" +
                "\n" +
                "  },\n" +
                "\n" +
                "  {\n" +
                "\n" +
                "    \"name\":\"张国立\",\n" +
                "\n" +
                "    \"sex\":\"男\",\n" +
                "\n" +
                "    \"email\":\"zhangguoli@123.com\",\n" +
                "\n" +
                "    \"url\":\"./img/4.jpg\"\n" +
                "\n" +
                "  },\n" +
                "\n" +
                "  {\n" +
                "\n" +
                "    \"name\":\"张铁林\",\n" +
                "\n" +
                "    \"sex\":\"男\",\n" +
                "\n" +
                "    \"email\":\"zhangtieli@123.com\",\n" +
                "\n" +
                "    \"url\":\"./img/5.jpg\"\n" +
                "\n" +
                "  },\n" +
                "\n" +
                "  {\n" +
                "\n" +
                "    \"name\":\"邓婕\",\n" +
                "\n" +
                "    \"sex\":\"女\",\n" +
                "\n" +
                "    \"email\":\"zhenjie@123.com\",\n" +
                "\n" +
                "    \"url\":\"./img/6.jpg\"\n" +
                "\n" +
                "  }\n" +
                "\n" +
                "]";
        return json;
    }

    @ApiOperation(value = "getJSON", response = String.class)
    @GetMapping("/toJson")
    public String demo2(){
      return   HttpURLConnectionUtil.getResult("http://192.168.111.129:9090/api/getJSON", User.class);
    }
}
