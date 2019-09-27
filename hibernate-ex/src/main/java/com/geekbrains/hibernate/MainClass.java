package com.geekbrains.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = null;

        try {

            session = factory.getCurrentSession();
            User student = new User();
            User emploee = new User();
            Product apple = new Product();
            Product toy =new Product();
            Product book =new Product();
            Product car = new Product();
            student.setName("Ivan");
            emploee.setName("Petr");
            apple.setTitle("Apple");
            apple.setCost(20);
            toy.setTitle("Barby");
            book.setTitle("Duma");
            car.setTitle("Car-toy");
            toy.setCost(500);
            book.setCost(200);
            car.setCost(300);
            student.addProduct(book);
            student.addProduct(toy);
            emploee.addProduct(apple);
            emploee.addProduct(book);
            emploee.addProduct(car);

            session.beginTransaction();

            session.save(apple);
            session.save(toy);
            session.save(book);
            session.save(car);
            session.save(student);
            session.save(emploee);

            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
        session = factory.getCurrentSession();
        session.beginTransaction();
        User user1 = session.get(User.class, 1);
        User user2 = session.get(User.class, 2);
        Product product1 = session.get(Product.class, 1);
        Product product2 = session.get(Product.class, 2);
        Product product3 = session.get(Product.class, 3);
        Product product4 = session.get(Product.class, 4);
        user1.addProduct(product1);
        user1.addProduct(product2);
        user2.addProduct(product2);
        user2.addProduct(product3);
        user2.addProduct(product4);
        try {
            session.update(user1);
            session.update(user2);
        }finally {
            factory.close();
            session.close();
        }


        session = factory.getCurrentSession();
        session.beginTransaction();

        List<Product> allProducts = session.createQuery("select  p from Product p").getResultList();
        for (Product p: allProducts) {
            System.out.println(p.getTitle() + " " + p.getCost());
        }

        List<User> allUsers = session.createQuery("select distinct  u from User u" +
                " left join fetch u.products where u.name = :name").setParameter("name", "Petr").getResultList();
        for (User u: allUsers) {
            System.out.println(" ID "+ u.getName() +": "+u.getId());
            for (Product p: u.getProducts()){
                System.out.println(p.getTitle() + " " + p.getCost());
            }
        }
        List<Product> products = session.createQuery("select distinct  p from Product p" +
                " right join fetch p.users where p.title = :title").setParameter("title", "Barby").getResultList();
        for (Product p: products) {
            System.out.println(" ID "+ p.getTitle() +": "+p.getId());
            for (User u: p.getUsers()){
                System.out.println(u.getId() + " " + u.getName());
            }
        }

        session.getTransaction().commit();




    }
}
