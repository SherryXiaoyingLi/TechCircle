package com.tencent.tars.client.testapp.impl;

import com.qq.tars.spring.annotation.TarsClient;
import com.qq.tars.spring.annotation.TarsServant;
import com.tencent.tars.client.testapp.ClientPostServant;
import com.tencent.tars.client.testapp.ClientServant;
import com.tencent.tars.client.testapp.PostPrx;
import com.tencent.tars.client.testapp.PostPrxCallback;

import java.util.concurrent.CompletableFuture;

@TarsServant("ClientPostObj")
public class ClientPostServantImpl implements ClientPostServant{
    @TarsClient("TestServer.PostServer.PostObj")
    PostPrx postPrx;
    String res = "";
    @Override
    public String rpcGetAuthorPost(int author) {
        //同步调用
        String syncres = postPrx.getAuthorPost(author);
        res += "sync_res: " + syncres + " ";
        //Util util = new Util();
        //UserInfo newUser = util.deserialize(syncres);
        //res += "sync_res: " + newUser.getUid() + " " + newUser.getUsername()+" "+newUser.getPassword()+ " "+newUser.getEmail() + " "+newUser.getAge() + " ";

        //异步调用
        postPrx.async_getAuthorPost(new PostPrxCallback() {

            @Override
            public void callback_expired() {
            }

            @Override
            public void callback_exception(Throwable ex) {
            }

            @Override
            public void callback_getAuthorPost(String ret) {
                res += "async_res: " + ret + " ";

            }
            
        }, author);
        //promise调用
        postPrx.promise_getAuthorPost(author).thenCompose(x -> {
            res += "promise_res: " + x;
            return CompletableFuture.completedFuture(0);
        });
        return res;
    }
}