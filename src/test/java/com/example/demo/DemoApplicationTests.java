package com.example.demo;

import com.example.demo.Utils.HttpURLConnectionUtil;
import com.example.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        HttpURLConnectionUtil.getResult("http://localhost:9090/api/getJSON", User.class);
    }

}
