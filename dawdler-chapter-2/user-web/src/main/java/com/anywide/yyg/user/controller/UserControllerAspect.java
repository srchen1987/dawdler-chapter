package com.anywide.yyg.user.controller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class UserControllerAspect {

	@Pointcut("execution(*  com.anywide.yyg.user.controller..UserController.list(..))")
	public void list() {
	}

	@Around("list()")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println(pjp.getSignature().getName() + ":" + pjp.getTarget());
		Object o = null;
		try {
			o = pjp.proceed();
		} catch (Throwable t) {
			throw t;
		}
		Object[] args = pjp.getArgs();
		System.out.println(o + ":\t" + args);
		return o;
	}

}