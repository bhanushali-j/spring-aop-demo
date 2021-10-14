//package com.demo.pmc.spring.aop;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.core.Ordered;
//import org.springframework.stereotype.Component;
//
//@Component
//@Aspect
//public class TransactionAspect implements Ordered {
//
//	
//	@Before("execution(* com.demo.pmc.spring.aop.*.*(..))")
//	 public void beforeTransactionAdvice(JoinPoint joinPoint) throws Throwable {
//	        System.out.println("****TransationAspect : " + joinPoint.getSignature().getName());
//	    }
//
//	@Override
//	public int getOrder() {
//		return 0;
//	}
//}
