package com.tencent.tars.client.testapp.impl;

import com.qq.tars.spring.annotation.TarsClient;
import com.qq.tars.spring.annotation.TarsServant;
import com.tencent.tars.client.testapp.ClientServant;
import com.tencent.tars.client.testapp.HelloPrx;
import com.tencent.tars.client.testapp.HelloPrxCallback;

import java.util.concurrent.CompletableFuture;

import com.tencent.tars.client.testapp.model.UserInfo;
import com.tencent.tars.client.testapp.util.Util;

@TarsServant("ClientObj")
public class ClientServantImpl implements ClientServant {
    @TarsClient("TestServer.HelloServer.HelloObj")
    HelloPrx helloPrx;

    String res = "";

    @Override
    public String rpcHello(int no, String name) {
        //同步调用
        String syncres = helloPrx.hello(1000, name);
        res += "sync_res: " + syncres + " ";
        //异步调用
        helloPrx.async_hello(new HelloPrxCallback() {

            @Override
            public void callback_expired() {
            }

            @Override
            public void callback_exception(Throwable ex) {
            }

            @Override
            public void callback_hello(String ret) {
                res += "async_res: " + ret + " ";

            }
            @Override
            public void callback_login(String ret) {
                res += "async_res: " + ret + " ";

            }
        }, 1000, name);
        //promise调用
        helloPrx.promise_hello(1000, name).thenCompose(x -> {
            res += "promise_res: " + x;
            return CompletableFuture.completedFuture(0);
        });
        return res;
    }
    @Override
    public String rpcLogin(String username, String password) {
        //同步调用
        String syncres = helloPrx.login(username, password);
        //res += "sync_res: " + syncres + " ";
        Util util = new Util();
        UserInfo newUser = util.deserialize(syncres);
        res += "sync_res: " + newUser.getUid() + " " + newUser.getUsername()+" "+newUser.getPassword()+ " "+newUser.getEmail() + " "+newUser.getAge() + " ";

        //异步调用
        helloPrx.async_login(new HelloPrxCallback() {

            @Override
            public void callback_expired() {
            }

            @Override
            public void callback_exception(Throwable ex) {
            }

            @Override
            public void callback_hello(String ret) {
                res += "async_res: " + ret + " ";

            }
            @Override
            public void callback_login(String ret) {
                res += "async_res: " + ret + " ";

            }
        }, username, password);
        //promise调用
        helloPrx.promise_login(username, password).thenCompose(x -> {
            res += "promise_res: " + x;
            return CompletableFuture.completedFuture(0);
        });
        return res;
    }
 
}
