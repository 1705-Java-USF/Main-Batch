package com.revature.logger;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.revature.dao.Dao;

@Aspect
public class LoggerClass {
	
	@Pointcut("execution(public com.*.*.* getSessionFactory())")
	public void getSfPointcut(){ //Stub method
		
	}
	
	@Pointcut("execution(public * set*(..))")
	public void advancedPC(){
		/*

		 * 
		 */
		
		//execution(public * get*(..))
		/*
		 * any public method, any return type,
		 * with a name that starts with 'get', 0+ parameters of any type. 
		 */
		
		//execution(public * get*(*))\
		/*
		 * any public method, any return type.
		 * With a name that starts with 'get'.
		 * Any type of parameter, but it MUST be 1 Parameter
		 * 
		 */
		
		//execution(public * get*(*, *)
		//only TWO parameters of any type
		
		//execution(public * get*(String, *)
		//First parameter must be a string, second can be whatever. ONLY 2
		
	}
	
	@Before("advancedPC()")
	public void check(){
		System.out.println("@BEFORE");
	}
	
	@Before("getSfPointcut()")
	public void loggingSf(){
		System.out.println("@BEFORE sf");
	}
	
	@AfterReturning(pointcut="getSfPointcut()", returning="obj")
	public void sfSuccess(Object obj){
		System.out.println("@AFTER: Success");
		System.out.println("obj: " + obj);
		System.out.println("LOGGED: " + ((Dao)obj).getSomething(1));
	}
	
	@AfterThrowing(pointcut="execution(* *(..))", throwing="ex")
	public void sfFailure(Exception ex){
		System.out.println("EXCEPTION OCCURRED");
		System.out.println("Ex: " + ex);
	}
	
	@After("getSfPointcut()")
	public void sfDone(){
		System.out.println("METHOD HAS EXECUTED");
	}
	@Around("getSfPointcut()")
	public Object sfTimer(ProceedingJoinPoint pjp){
		//At this point, everything is being done before the pointcut executes.
		Object obj = null;
		Date start = new Date();
		
		try{
			System.out.println("@around: invoking: " + pjp.getSignature());
			obj = pjp.proceed(); //We are telling the method to execute
			//Everything past this point, is executed after original pointcut method executes
		}catch(Throwable e){
			e.printStackTrace();
		}
		Date end = new Date();
		System.out.println("@Around grabbed this object: " + obj);
		System.out.println("Around: SessionFactory took " +
								(end.getTime() - start.getTime()) +
								" milliseconds to complete.");
		
		return obj;
	}
}
