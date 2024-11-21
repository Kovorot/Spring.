package ru.kovorot.spring.aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents() {
        Student st1 = new Student("Andrey Vasilev", 4, 7.5);
        Student st2 = new Student("Michail Ivanov", 2, 8.3);
        Student st3 = new Student("Elena Sidorova", 1, 9.1);

        students.addAll(Arrays.asList(st1, st2, st3));
    }

    public List<Student> getStudents() {
        System.out.println("Начало работы метода getStudents");
//        System.out.println(students.get(3));
        System.out.println("Information from method getStudents:");
        System.out.println(students);
        return students;
    }
}
