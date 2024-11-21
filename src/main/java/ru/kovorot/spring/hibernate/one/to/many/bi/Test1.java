package ru.kovorot.spring.hibernate.one.to.many.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kovorot.spring.hibernate.one.to.many.bi.entity.Department;
import ru.kovorot.spring.hibernate.one.to.many.bi.entity.Employee;

public class Test1 {

    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class);

        try (SessionFactory factory = configuration.buildSessionFactory()) {
            try (Session session = factory.getCurrentSession()) {
//                Department department = new Department("Sales", 800, 1500);
//                Employee emp1 = new Employee("Andrey", "Vasilev", 800);
//                Employee emp2 = new Employee("Elena", "Smirnova", 1500);
//                Employee emp3 = new Employee("Anton", "Sidorov", 1200);
//
//                department.addEmployeeToDepartment(emp1);
//                department.addEmployeeToDepartment(emp2);
//                department.addEmployeeToDepartment(emp3);

                session.beginTransaction();

//                session.save(department);

                System.out.println("Get department");
                Department department = session.get(Department.class, 5);
                System.out.println("Show department");
                System.out.println(department);

//                Employee employee = session.get(Employee.class, 1);
//                System.out.println(employee);
//                System.out.println(employee.getDepartment());

//                Employee employee = session.get(Employee.class, 4);
//                session.delete(employee);

                session.getTransaction().commit();

                System.out.println("Show employees");
                System.out.println(department.getEmps());

                System.out.println("Done");
            }
        }
    }
}
