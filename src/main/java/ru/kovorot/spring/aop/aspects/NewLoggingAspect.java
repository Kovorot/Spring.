package ru.kovorot.spring.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");

        Object result;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("Было поймано исключение: " + e);
            result = "Неизвестное название книги";
        }

        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку вернули книгу книгу");
        return result;
    }
}
