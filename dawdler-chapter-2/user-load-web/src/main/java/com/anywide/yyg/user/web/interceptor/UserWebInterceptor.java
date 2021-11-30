package com.anywide.yyg.user.web.interceptor;

import com.anywide.dawdler.clientplug.annotation.RequestMapping;
import com.anywide.dawdler.clientplug.web.handler.ViewForward;
import com.anywide.dawdler.clientplug.web.interceptor.HandlerInterceptor;
import com.anywide.dawdler.core.annotation.Order;

@Order(2)
public class UserWebInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(Object controller, ViewForward viewForward, RequestMapping requestMapping)
			throws Exception {
		String uri = viewForward.getRequest().getRequestURI();
		System.out.println(this.getClass().getSimpleName() + " preHandle " + uri);
		return true;
	}

	@Override
	public void postHandle(Object controller, ViewForward viewForward, RequestMapping requestMapping, Throwable ex)
			throws Exception {
		System.out.println(this.getClass().getSimpleName() + " postHandle ");
	}

	@Override
	public void afterCompletion(Object controller, ViewForward viewForward, RequestMapping requestMapping,
			Throwable ex) {
		System.out.println(this.getClass().getSimpleName() + " afterCompletion ");
	}

}
