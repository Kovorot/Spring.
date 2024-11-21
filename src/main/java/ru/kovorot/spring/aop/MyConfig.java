package ru.kovorot.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("ru.kovorot.spring.aop")
@EnableAspectJAutoProxy
public class MyConfig {
}
