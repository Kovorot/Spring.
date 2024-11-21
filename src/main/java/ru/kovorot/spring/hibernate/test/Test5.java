package ru.kovorot.spring.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kovorot.spring.hibernate.test.entity.Employee;

public class Test5 {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class);

        try (SessionFactory factory = configuration.buildSessionFactory()) {
            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();

//                Employee emp = session.get(Employee.class, 1);
//                session.delete(emp);

                session.createQuery("delete Employee where name = 'Aleksandr'").executeUpdate();

                session.getTransaction().commit();
            }
            System.out.println("Done");
        }
    }
}
