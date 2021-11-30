package com.anywide.dawdler.demo.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.anywide.dawdler.client.ConnectionPool;
import com.anywide.dawdler.client.ServiceFactory;
import com.anywide.dawdler.client.filter.AsyncInvokeFutureHolder;
import com.anywide.dawdler.core.thread.InvokeFuture;
import com.anywide.dawdler.demo.entity.Message;
import com.anywide.dawdler.demo.service.HelloService;

public class ProxyInterfaceCall {
	
	public static void main(String[] args) throws Exception {
		test();
	}

	public static void test() throws Exception {
		HelloService hs = ServiceFactory.getService(HelloService.class);
		Map<String, Object> param = new HashMap<>();
		param.put("name", "jackson.song");
		try {
			 List<Message> messageList = hs.responseList(param);
			 System.out.println(messageList);
		} catch (Throwable e) {
			System.out.println("exception:"+e.getMessage());
		}
		ConnectionPool.shutdown();
	}
	
	/**
	 * 
	*  异步调用,接口中定义了异步调用
	* @RemoteServiceAssistant(async = true)
	* public String say(String text);
	*
	 */
	public static void testAsync() throws Exception {
		HelloService hs = ServiceFactory.getService(HelloService.class);
		hs.say("hello");
		InvokeFuture<String> future = AsyncInvokeFutureHolder.getContext().getInvokeFuture();
		System.out.println(future.getResult());
		ConnectionPool.shutdown();
	}
}
