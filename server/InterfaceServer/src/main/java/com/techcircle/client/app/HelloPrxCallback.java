package com.techcircle.client.app;

import com.qq.tars.rpc.protocol.tars.support.TarsAbstractCallback;

public abstract class HelloPrxCallback extends TarsAbstractCallback {

	public abstract void callback_hello(String ret);

}
