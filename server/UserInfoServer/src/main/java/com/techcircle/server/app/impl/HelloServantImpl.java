package com.techcircle.server.app.impl;

import com.techcircle.server.app.HelloServant;
import com.qq.tars.spring.annotation.TarsServant;

@TarsServant("HelloObj")
public class HelloServantImpl implements HelloServant {

    @Override
    public String hello(int no, String name) {
        return String.format("hello no=%s, name=%s, time=%s", no, name, System.currentTimeMillis());
    }
}
