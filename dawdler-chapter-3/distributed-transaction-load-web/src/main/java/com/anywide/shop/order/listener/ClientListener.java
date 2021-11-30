package com.anywide.shop.order.listener;

import java.util.Map;

import javax.servlet.ServletContext;

import org.aspectj.lang.ProceedingJoinPoint;

import com.anywide.dawdler.clientplug.web.listener.WebContextListener;
import com.anywide.dawdler.distributed.transaction.context.DistributedTransactionContext;
import com.anywide.dawdler.distributed.transaction.interceptor.TransactionInterceptInvoker;
import com.anywide.dawdler.distributed.transaction.interceptor.TransactionInterceptInvokerHolder;

public class ClientListener implements WebContextListener {

	@Override
	public void contextDestroyed(ServletContext arg0) {
	}

	@Override
	public void contextInitialized(ServletContext arg0) {
		TransactionInterceptInvokerHolder.setTransactionInterceptInvoker(new TransactionInterceptInvoker() {
			@Override
			public Object invoke(ProceedingJoinPoint invocation, DistributedTransactionContext tc) throws Throwable {
				Object result = invocation.proceed();
				if (result instanceof Map) {
					Map resultMap = (Map) result;
					Boolean success = (Boolean) resultMap.get("success");
					if (success == null || !success) {
						tc.setCancel(true);
					}
				}
				return result;
			}
		});
	}

}
