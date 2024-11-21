package ru.kovorot.spring.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kovorot.spring.hibernate.test.entity.Employee;

import java.util.List;

public class Test3 {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class);

        try (SessionFactory factory = configuration.buildSessionFactory()) {
            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();

//                List<Employee> emps = session.createQuery("from Employee").getResultList();

                List<Employee> emps = session.createQuery("from Employee where name = 'Aleksandr' AND salary > 650").getResultList();

                for (Employee e : emps) {
                    System.out.println(e);
                }

                session.getTransaction().commit();
            }
            System.out.println("Done");
        }
    }
}
