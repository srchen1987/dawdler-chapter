package com.anywide.yyg.user.controller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
//一个web端的aop示例
@Aspect
public class AUserServiceAopAspect1 {

	@Pointcut("execution(*  com.anywide.shop.order.controller..OrderController.order())")
	public void order() {
	}

	@Around("order()")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("my start ...\t" + pjp.getSignature().getName() + ":" + pjp.getTarget());
		Object o = null;
		try {
			o = pjp.proceed();
		} catch (Throwable t) {
			throw t;
		}
		Object[] args = pjp.getArgs();
		System.out.println("over:\t" + args);
		return o;
	}

}