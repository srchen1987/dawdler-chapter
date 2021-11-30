package com.anywide.dawdler.demo.test;

import com.anywide.dawdler.client.ConnectionPool;
import com.anywide.dawdler.client.Transaction;
import com.anywide.dawdler.client.TransactionProvider;
import com.anywide.dawdler.client.filter.AsyncInvokeFutureHolder;
import com.anywide.dawdler.core.thread.InvokeFuture;

public class APICall {
	
	public static void main(String[] args) throws Exception {
		test();
	}
	
	
	public static void test() throws Exception {
		Transaction tr = TransactionProvider.getTransaction("simple-service");
		tr.setServiceName("com.anywide.dawdler.demo.service.HelloService");
		tr.setMethod("say");
		tr.addString("jackson");
		tr.setAsync(true);
		Object obj = tr.executeResult();
		InvokeFuture<String> future = AsyncInvokeFutureHolder.getContext().getInvokeFuture();
		System.out.println(obj);
		System.out.println(future.getResult());
		System.out.println(Thread.currentThread()+":#"+future);
		ConnectionPool.shutdown();	
	}

	public static void testAsync() throws Exception {
		Transaction tr = TransactionProvider.getTransaction("simple-service");
		tr.setServiceName("com.anywide.dawdler.demo.service.HelloService");
		tr.setMethod("say");
		tr.addString("jackson");
		tr.setAsync(true);
		Object obj = tr.executeResult();
		InvokeFuture<String> future = AsyncInvokeFutureHolder.getContext().getInvokeFuture();
		System.out.println(obj);
		System.out.println(future.getResult());
		System.out.println(Thread.currentThread()+":#"+future);
		ConnectionPool.shutdown();	
	}
}
