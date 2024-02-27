package org.example;

//* 2. С помощью JPA(Hibernate) выполнить:
//        * 2.1 Описать сущность Book из пункта 1.1
//        * 2.2 Создать Session и сохранить в таблицу 10 книг
//        * 2.3 Выгрузить список книг какого-то автора

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.List;

public class Jpa {
    public static void main(String[] args) throws SQLException {
        List<Book> books = List.of(
                (new Book("Pushkin", "Ruslan i Ludmila")),
                (new Book("Pushkin", "Poltava")),
                (new Book("Pushkin", "Medny vsadnik")),
                (new Book("Pushkin", "Boris Godunov")),
                (new Book("Pushkin", "Dubrovsky")),
                (new Book("Lermontov", "A Hero of Our Time")),
                (new Book("Lermontov", "Death of the Poet")),
                (new Book("Lermontov", "Masquerade")),
                (new Book("Gogol", "The Nose")),
                (new Book("Gogol", "Viy"))
        );

        final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml").buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            books.forEach(session::save);
            session.getTransaction().commit();
        }

        try (Session session = sessionFactory.openSession()) {
            List<Book> result = session.createQuery("select u from Book u where author = 'Gogol'", Book.class).getResultList();
            System.out.println("result " + result.toString());
        }
        sessionFactory.close();
    }
}