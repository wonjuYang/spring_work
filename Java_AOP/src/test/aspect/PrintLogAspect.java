package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
/*
 * 횡단 관심사(Cross Concern)를 Aspect로 작성하기
 */
public class PrintLogAspect {
   public Object printLog(ProceedingJoinPoint jointPoint)
         throws Throwable{
      System.out.println("--비즈니스 로직을 수행하기 이전입니다.");
      /*
       * joinPoint 객체의 proceed() 메소드를 호출하는 시점이
       * AOP 가 적용된 메소드가 수행되는 시점이다.
       * 
       * .proceed() 메소드가 리턴해주는 객체가 AOP가 적용된 메소드가 리턴해주는 객체이다
       * 만일 AOP 가 적용된 메솓의 리턴 type이 void이면 obj는 null이다.
       * 
       */
      Object obj=jointPoint.proceed();
      System.out.println("--비즈니스 로직을 수행했습니다.");
      return obj;
      
   }
}
