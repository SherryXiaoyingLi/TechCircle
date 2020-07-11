package com.techcircle.client.app.impl;

import com.qq.tars.spring.annotation.TarsClient;
import com.qq.tars.spring.annotation.TarsServant;
import com.techcircle.client.app.LoginServant;
import com.techcircle.client.app.LoginPrx;
import com.techcircle.client.app.LoginPrxCallback;

import java.util.concurrent.CompletableFuture;


@TarsServant("LoginClientObj")
public class LoginServantImpl implements LoginServant {
    @TarsClient("TestServer.HelloServer.LoginObj")
    LoginPrx loginPrx;

    String res = "";

    @Override
    public String rpcLogin(String username, String password) {

        String syncres = loginPrx.login(username, password);
        res += "sync_res: " + syncres + " ";
        //异步调用
        loginPrx.async_login(new LoginPrxCallback() {

            @Override
            public void callback_expired() {
            }

            @Override
            public void callback_exception(Throwable ex) {
            }

            @Override
            public void callback_login(String ret) {
                res += "async_res: " + ret + " ";

            }
        }, username, password);
        //promise调用
        loginPrx.promise_login(username, password).thenCompose(x -> {
            res += "promise_res: " + x;
            return CompletableFuture.completedFuture(0);
        });
        return res;
    }
}
