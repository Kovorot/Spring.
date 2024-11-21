package ru.kovorot.spring.hibernate.one.to.one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kovorot.spring.hibernate.one.to.one.entity.Detail;
import ru.kovorot.spring.hibernate.one.to.one.entity.Employee;

public class Test2 {

    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class);

        try (SessionFactory factory = configuration.buildSessionFactory()) {
            try (Session session = factory.getCurrentSession()) {
//                Employee employee = new Employee("Nikolay", "Ivanov", "HR", 850);
//                Detail detail = new Detail("New-York", "4325624562", "Niko@gmail.com");

                session.beginTransaction();

//                detail.setEmployee(employee);
//                employee.setEmpDetail(detail);
//                session.save(detail);

                Detail detail = session.get(Detail.class, 1);
                detail.getEmployee().setEmpDetail(null);
                session.delete(detail);

                session.getTransaction().commit();

                System.out.println("Done");
            }
        }
    }
}
