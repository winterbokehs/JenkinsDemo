package com.example.demo.config;

import com.example.demo.pojo.LoginUser;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoThreadHost  {
    private static final ThreadLocal<LoginUser> threadLocal = new ThreadLocal<>();
    public void setUser(LoginUser user) {
        threadLocal.set(user);
    }

    public LoginUser getUser() {
        return threadLocal.get();
    }

    public void remove() {
        threadLocal.remove();
    }
}
