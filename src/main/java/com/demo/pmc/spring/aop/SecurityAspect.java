package com.demo.pmc.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class SecurityAspect {
	
	private final Logger log=LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* com.demo.pmc.spring.aop.*.*(..))")
	 public void beforeSecurityAdvice(JoinPoint joinPoint) throws Throwable {
		
		String className=joinPoint.getSignature().getDeclaringTypeName();
		String methodName=joinPoint.getSignature().getName();
		log.info("Inside Before Advice : "+className+methodName+"()"+"-----Order 0------");
	    }
	
	
	@After("execution(* com.demo.pmc.spring.aop.*.*(..))")
	 public void AfterSecurityAdvice(JoinPoint joinPoint) throws Throwable {
		
		String className=joinPoint.getSignature().getDeclaringTypeName();
		String methodName=joinPoint.getSignature().getName();
		log.info("Inside After Advice : "+className+methodName+"()"+"-----Order 0------");
	    }
	
}
