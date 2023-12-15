package jp.co.sss.shop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SampleAOP {

	@Before("execution(* jp.co.sss.shop.controller.*.*(..))")
	public void printLog(JoinPoint joinPoint) {
		System.out.println("*****  " + joinPoint.getSignature());
		for(Object arg : joinPoint.getArgs()) {
			System.out.print(arg+", ");
		}
		System.out.println("*****  \n");
	}
}
