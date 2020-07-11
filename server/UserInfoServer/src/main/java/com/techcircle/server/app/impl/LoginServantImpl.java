package com.techcircle.server.app.impl;

import com.techcircle.server.app.LoginServant;
import com.qq.tars.spring.annotation.TarsServant;

@TarsServant("LoginObj")
public class LoginServantImpl implements LoginServant {

    @Override
    public String login(String username, String password) {
        return String.format("hello username=%s, password=%s, time=%s", username, password, System.currentTimeMillis());
    }
}
