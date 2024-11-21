package ru.kovorot.spring.spring.introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");

        Dog myDog = context.getBean("dogBean", Dog.class);
        myDog.say();
//        Dog yourDog = context.getBean("dogBean", Dog.class);
//
//        System.out.println(yourDog == myDog);
//        System.out.println(myDog);
//        System.out.println(yourDog);

        context.close();
    }
}
