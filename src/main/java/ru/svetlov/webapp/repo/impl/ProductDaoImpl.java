package ru.svetlov.webapp.repo.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.svetlov.webapp.domain.*;
import ru.svetlov.webapp.repo.ProductDao;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Product create(Product product) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.save(product);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public Product getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> getByIds(List<Long> ids) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            List<Product> products = session
                    .createQuery("select p from Product p where p.id in (:list)", Product.class)
                    .setParameter("list", ids)
                    .getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public List<Product> getAll() {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            List<Product> products = session.createNamedQuery("getAllProducts", Product.class).getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void update(Product product) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.update(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Product product) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Long> getProductCustomersById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            String query = "select distinct op.order.customer.id from OrderedProduct op where op.product.id = :id";
            List<Long> products = session
                    .createQuery(query, Long.class)
                    .setParameter("id", id)
                    .getResultList();
            session.getTransaction().commit();
            return products;
        }
    }
}
