package ru.kovorot.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class SecurityAspect {

    @Before("ru.kovorot.spring.aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice() {
        System.out.println("beforeAddSecurityAdvice: проверка прав на получение книги или журнала");
        System.out.println("-------------------------------------------------------------------");
    }
}
