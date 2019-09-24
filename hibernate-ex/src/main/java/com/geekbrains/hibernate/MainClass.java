package com.geekbrains.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Reader.class)
                .buildSessionFactory();
        // CRUD
        Session session = null;
//
//        session = factory.getCurrentSession();
//        session.beginTransaction();
//        List<Reader> readers = session.createQuery("from Reader").getResultList();
//        System.out.println(readers);
//        session.getTransaction().commit();

//        try {
//            // CREATE
//            session = factory.getCurrentSession();
//            Book tmpBook = new Book();
//            tmpBook.setTitle("Java 2");
//            session.beginTransaction();
//            session.save(tmpBook);
//            session.getTransaction().commit();
//        } finally {
//            factory.close();
//            session.close();
//        }
//
//        try {
////           // CREATE
//            session = factory.getCurrentSession();
//            Book tmpBook = new Book();
//            tmpBook.setTitle("Java 2");
//            session.beginTransaction();
//            session.save(tmpBook);
//            session.getTransaction().commit();
//        } finally {
//            factory.close();
//            session.close();
//        }

           // READ
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Book harryPotterBook = session.get(Book.class, 2);
//            session.getTransaction().commit();
//            System.out.println(harryPotterBook);

//            UPDATE
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Book bookJava1 = session.get(Book.class, 3);
//            bookJava1.setTitle("Java 1 Advanced");
//            session.getTransaction().commit();
//            System.out.println(bookJava1);

//DELETE
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Book bookJava1 = session.get(Book.class, 1);
//            session.delete(bookJava1);
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//////             подставлем условие 1 из трех законменированных вариантов
//         //List<Book> allBooks = session.createQuery("from Book").getResultList();
//          //List<Book> allBooks = session.createQuery("from Book b where b.title = 'Java 1 Advanced'").getResultList();
//        //  List<Book> allBooks = session.createQuery("from Book b where b.title = :title").setParameter("title", "Java 2").getResultList();
//            System.out.println(allBooks);
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            session.createQuery("delete from Book where id = 3").executeUpdate();
//            session.getTransaction().commit();


        //            session.createQuery("delete from Book where id = 3").executeUpdate();

// CREATE
//        try {
//            session = factory.getCurrentSession();
//            Author author = new Author();
//            author.setName("rolling1");
//            session.beginTransaction();
//            session.save(author);
//            session.getTransaction().commit();
//        } finally {
//            factory.close();
//            session.close();
//        }

//        session = factory.getCurrentSession();
//        session.beginTransaction();
//        Author author = session.get(Author.class, 2);
//        session.delete(author);
//        session.getTransaction().commit();

//        session = factory.getCurrentSession();
//        session.beginTransaction();
//        Author author = session.get(Author.class, 2);
//        session.delete(author);
//        session.getTransaction().commit();
////
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Reader reader = session.get(Reader.class, 1);
//            System.out.println(reader);
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            List<Author> author = session.createQuery("from Author").getResultList();
//            System.out.println(author);
//            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            Author author = session.get(Author.class, 1);
            session.delete(author);
            session.getTransaction().commit();
//        } finally {
//            factory.close();
//            session.close();
//        }
    }
}
