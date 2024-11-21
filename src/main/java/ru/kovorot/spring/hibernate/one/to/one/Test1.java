package ru.kovorot.spring.hibernate.one.to.one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kovorot.spring.hibernate.one.to.one.entity.Detail;
import ru.kovorot.spring.hibernate.one.to.one.entity.Employee;

public class Test1 {

    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class);

        try (SessionFactory factory = configuration.buildSessionFactory()) {
            try (Session session = factory.getCurrentSession()) {
//                Employee employee = new Employee("Oleg", "Smirnov", "Sales", 700);
//                Detail detail = new Detail("Moscow", "12345534", "Oleg@mail.ru");
//                employee.setEmpDetail(detail);

                session.beginTransaction();

//                session.save(employee);

                Employee emp = session.get(Employee.class, 2);
                session.delete(emp);

                session.getTransaction().commit();

                System.out.println("Done");
            }
        }
    }
}
