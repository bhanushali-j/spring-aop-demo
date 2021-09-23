package com.demo.pmc.spring.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private final Logger log=LoggerFactory.getLogger(this.getClass());
	
	@Before(value="execution(* com.demo.pmc.spring.aop.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		log.info("Inside Before Advice while calling method : "+joinPoint.getSignature().getName()+"()");
	}
	
	
	@After(value="execution(* com.demo.pmc.spring.aop.EmployeeService.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		log.info("Inside After Advice whilce calling method : "+joinPoint.getSignature().getName()+"()");
	}
	
	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
	public void springBeanControllerPointCut() {
		
	}
	
	@Pointcut("within(com.demo.pmc.spring.aop.*)")
	public void appPackageControllerPointCut() {
		
	}
	
	@AfterThrowing(pointcut = "springBeanControllerPointCut() && appPackageControllerPointCut()",throwing="e")
	public void logAfterThrowing(JoinPoint joinPoint,Throwable e) {
		
		String className=joinPoint.getSignature().getDeclaringTypeName();
		String methodName=joinPoint.getSignature().getName();
		log.error("Exception in {}.{}() with cause = {}",className,methodName,e.getCause()!=null?e.getCause():"NULL");
	}
	
	@Around("springBeanControllerPointCut() && appPackageControllerPointCut()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
		
		String className=joinPoint.getSignature().getDeclaringTypeName();
		String methodName=joinPoint.getSignature().getName();
		
		log.info("Enter : {}.{}() with argument[s] = {}",className,methodName,Arrays.toString(joinPoint.getArgs()));
	
		try {
			
			Object result=joinPoint.proceed();
			if(log.isDebugEnabled()) {
				log.debug("Exit: {}.{}() with result = {}",className,methodName,result);
			}else {
				log.info("Exit: {}.{}()", className, methodName);
			}
			return result;
		}
		catch(IllegalArgumentException e) {
			log.error("Illegal argument(s) in {}.{}()", className, methodName,
					e.getCause() != null ? e.getCause() : "NULL");
			throw e;
		}
	}
} 