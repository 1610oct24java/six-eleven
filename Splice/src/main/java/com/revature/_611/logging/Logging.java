package com.revature._611.logging;

import com.revature._611.logging.LoggingUtil;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logging {

	LoggingUtil logUtil = new LoggingUtil();

	@Around("execution(* *(..))")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {

		StringBuffer message = new StringBuffer();
		message.append(pjp.getTarget().getClass().getName());
		message.append(".");
		message.append(pjp.getSignature().getName());
		message.append("(");
		Object[] args = pjp.getArgs();
		for (int i = 0; i < args.length; i++) {
			message.append(args[i]).append(",");
		}
		if (args.length > 0) {
			message.deleteCharAt(message.length() - 1);
		}
		
		message.append(")");
		System.err.println("IN LOGAROUND METHOD");
		logUtil.logDebug(message.toString());
		
		Object obj = pjp.proceed();

		return obj;
	}
}