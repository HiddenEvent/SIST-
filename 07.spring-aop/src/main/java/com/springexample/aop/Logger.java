package com.springexample.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {	
	
	//public void logBefore() {
	public void logBefore(JoinPoint joinPoint) { //JoinPoint 전달인자 : 현재 실행되는 메서드 정보		
		System.out.println(String.format("======> Logging.logBefore %s.%s <=======",
				joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName()));
	}	
	
	//public void logAfter() {
	public void logAfter(JoinPoint joinPoint) {
		System.out.println(String.format("======> Logging.logAfter %s.%s <=======",
				joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName()));
	}
	
	public Object logAround(ProceedingJoinPoint joinPoint) { //Around Advice는 반드시 ProceedingJoinPoint 전달인자를 가져야 합니다.
		
		long begin = System.nanoTime(); //시작시간 - Before Advice
		
		Object returnValue = null;
		try {
			returnValue = joinPoint.proceed(); //실제 메서드 호출
		} catch (Throwable e) {			
		}		
		
		long end = System.nanoTime(); //종료시간 - After Advice
		
		System.out.printf("[[[ %s.%s 실행 소요시간 : %d ]]]\n", 
				joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(),
				end - begin);
		
		return returnValue;
		
	}
}












