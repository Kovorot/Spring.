package ru.kovorot.spring.hibernate.one.to.many.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kovorot.spring.hibernate.one.to.many.uni.entity.Department;
import ru.kovorot.spring.hibernate.one.to.many.uni.entity.Employee;

public class Test1 {

    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class);

        try (SessionFactory factory = configuration.buildSessionFactory()) {
            try (Session session = factory.getCurrentSession()) {
//                Department department = new Department("HR", 500, 1500);
//                Employee emp1 = new Employee("Oleg", "Ivanov", 800);
//                Employee emp2 = new Employee("Zaur", "Sidorov", 1000);
//
//                department.addEmployeeToDepartment(emp1);
//                department.addEmployeeToDepartment(emp2);

                session.beginTransaction();

//                session.save(department);

                Department department = session.get(Department.class, 4);
                session.delete(department);

//                Employee employee = session.get(Employee.class, 1);
//                System.out.println(employee);
//                System.out.println(employee.getDepartment());

//                Employee employee = session.get(Employee.class, 4);
//                session.delete(employee);

                session.getTransaction().commit();

                System.out.println("Done");
            }
        }
    }
}
