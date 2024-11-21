package ru.kovorot.spring.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kovorot.spring.hibernate.test.entity.Employee;

public class Test2 {

    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class);

        try (SessionFactory factory = configuration.buildSessionFactory()) {
            try (Session session = factory.getCurrentSession()) {
                Employee employee = new Employee("Oleg", "Sidorov", "HR", 700);

                session.beginTransaction();
                session.save(employee);

                int myId = employee.getId();
                Employee employee1 = session.get(Employee.class, myId);
                session.getTransaction().commit();
                System.out.println(employee1);
            }
            System.out.println("Done");
        }
    }
}
