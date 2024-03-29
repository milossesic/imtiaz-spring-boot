package com.jrp.pma.logging;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationLoggerAspect {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(com.jrp.pma.controllers..*)")
	public void definePackagePointcuts() {
		
	}
	
	@Before("definePackagePointcuts()")
	public void logBefore(JoinPoint jp) {
		log.debug(" \n \n \n ");
		log.debug(">>===============> Before Method Execution \n {}. {} with arguments[s] = {} ",
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
		log.debug("_______________________ \n \n \n ");
	}
	
	@Around("definePackagePointcuts()")
	public Object logAround(ProceedingJoinPoint pjp) {
		log.debug(" \n \n \n ");
		log.debug(">>===============> Before Method Execution \n {}. {} with arguments[s] = {} ",
				pjp.getSignature().getDeclaringTypeName(),
				pjp.getSignature().getName(), Arrays.toString(pjp.getArgs()));
		log.debug("_______________________ \n \n \n ");
		
		Object o = null;
		try {
			o = pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.debug(" \n \n \n ");
		log.debug(">>===============> Before Method Execution \n {}. {} with arguments[s] = {} ",
				pjp.getSignature().getDeclaringTypeName(),
				pjp.getSignature().getName(), Arrays.toString(pjp.getArgs()));
		log.debug("_______________________ \n \n \n ");
		
		return o;
	}

}
