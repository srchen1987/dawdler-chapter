package com.anywide.yyg.user.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class UserServiceAspect {

	@Around("execution(*  com.anywide.yyg.user.service.impl .*.selectUserList(..))")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("start ...\tlogAround" + pjp.getSignature().getName());
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