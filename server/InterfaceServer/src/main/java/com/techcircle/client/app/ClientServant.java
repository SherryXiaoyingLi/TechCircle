package com.techcircle.client.app;

import com.qq.tars.protocol.annotation.Servant;


@Servant
public interface ClientServant {
    public String rpcHello(int no, String name);
}
