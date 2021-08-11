package ru.svetlov.webapp.repo.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.svetlov.webapp.domain.Customer;
import ru.svetlov.webapp.domain.OrderedProduct;
import ru.svetlov.webapp.repo.CustomerDao;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {


    private final SessionFactory sessionFactory;

    @Autowired
    public CustomerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Customer create(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.save(customer);
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public Customer getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            Customer customer = session.get(Customer.class, id);
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public List<Customer> getByIds(List<Long> ids) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            List<Customer> customers = session
                    .createQuery("select c from Customer c where c.id in (:list)", Customer.class)
                    .setParameter("list", ids)
                    .getResultList();
            session.getTransaction().commit();
            return customers;
        }
    }

    @Override
    public List<Customer> getAll() {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            List<Customer> customers = session
                    .createNamedQuery("getAllCustomers", Customer.class)
                    .getResultList();
            session.getTransaction().commit();
            return customers;
        }
    }

    @Override
    public void update(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.update(customer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.delete(customer);
            session.getTransaction().commit();
        }
    }

    // не уверен, что правильнее - отдавать из CustomerDAO коллекцию Product напрямую
    // или отдать список Product.id и по ним запрашивать коллекцию у ProductService?
    @Override
    public List<Long> getProductsByCustomerId(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            String query = "select distinct op.product.id from OrderedProduct op where op.order.customer.id = :id";
            List<Long> products = session
                    .createQuery(query, Long.class)
                    .setParameter("id", id)
                    .getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public List<OrderedProduct> getOrderedProductsByCustomerId(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            String query = "select op from OrderedProduct op join fetch op.product where op.order.customer.id = :id";
            List<OrderedProduct> products = session
                    .createQuery(query, OrderedProduct.class)
                    .setParameter("id", id)
                    .getResultList();
            session.getTransaction().commit();
            return products;
        }
    }
}
