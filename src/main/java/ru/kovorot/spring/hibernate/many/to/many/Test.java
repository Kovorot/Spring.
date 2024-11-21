package ru.kovorot.spring.hibernate.many.to.many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kovorot.spring.hibernate.many.to.many.entity.Child;
import ru.kovorot.spring.hibernate.one.to.many.uni.entity.Section;

public class Test {

    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (Session session = sessionFactory.getCurrentSession()) {
//                Section section1 = new Section("Dance");
//
//                Child child1 = new Child("Olya", 12);
//                Child child2 = new Child("Grisha", 8);
//                Child child3 = new Child("Pavel", 9);
//
//                section1.addChildToSection(child1);
//                section1.addChildToSection(child2);
//                section1.addChildToSection(child3);

//                Section section1 = new Section("Wolleyball");
//                Section section2 = new Section("Chess");
//                Section section3 = new Section("Maths");
//
//                Child child1 = new Child("Igor", 10);
//
//                child1.addSectionToChild(section1);
//                child1.addSectionToChild(section2);
//                child1.addSectionToChild(section3);

                session.beginTransaction();

//                session.persist(section1);

//                session.save(child1);

//                Section section = session.get(Section.class, 7);
//                System.out.println(section);
//                System.out.println(section.getChildren());
//
//                session.delete(section);

//                Child child = session.get(Child.class, 4);
//                System.out.println(child);
//                System.out.println(child.getSections());

//                Section section = session.get(Section.class, 1);
//                session.delete(section);

                Child child = session.get(Child.class, 5);
                session.delete(child);

                session.getTransaction().commit();
                System.out.println("Done");
            }
        }
    }
}
