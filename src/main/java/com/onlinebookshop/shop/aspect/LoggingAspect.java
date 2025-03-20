package com.onlinebookshop.shop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Before("execution(* com.onlinebookshop.shop.service.*.*(..))")
	public void beforeServiceMethods() {
		System.out.println("----Logging from aspect : Method called in service layer-------");

	}

@After("execution(* com.onlinebookshop.shop.service.*.*(..))")
public void afterServiceMethods() {
	System.out.println("----Logging from aspect: Method execution completed in service layer-------");
}

@Around("execution(* com.onlinebookshop.shop.service.*.*(..))")
public Object aroundServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
	long startTime = System.currentTimeMillis();
	Object result = joinPoint.proceed();
	long endTime = System.currentTimeMillis();
	System.out.println("------Logging: Method " + joinPoint.getSignature().getName() + " executed in "
			+ (endTime - startTime) + " ms");
	return result;
}
	@AfterReturning("execution(* com.onlinebookshop.shop.service.*.*(..)) ")
	public void afterReturningServicemethod() {
		System.out.println("-------Logging from aspect : after returning method called in service layer--------");
	}

	@AfterThrowing("execution(* com.onlinebookshop.shop.service.*.*(..)) ")
	public void afterThrowingServicemethod() {
		System.out.println("-------Logging from aspect : after throwing method called in service layer--------");
	}


}

