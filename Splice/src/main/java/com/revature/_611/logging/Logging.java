package com.revature._611.logging;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logging {

	{
		try {
			PrintWriter log = new PrintWriter("log.txt", "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	@Around("execution(* com.revature._611..*.*(..))")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {

			Object obj = pjp.proceed();

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
			
			
			
			return obj;
	}

}