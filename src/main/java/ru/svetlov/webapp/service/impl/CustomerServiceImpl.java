package ru.svetlov.webapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import ru.svetlov.webapp.domain.Customer;
import ru.svetlov.webapp.domain.OrderedProduct;
import ru.svetlov.webapp.domain.Product;
import ru.svetlov.webapp.repo.CustomerDao;
import ru.svetlov.webapp.service.CustomerService;
import ru.svetlov.webapp.service.ProductService;

import java.util.Collections;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao dao;
    private final ProductService productService;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao, @Lazy ProductService productService) {
        this.dao = customerDao;
        this.productService = productService;
    }


    @Override
    public Customer getById(Long id) {
        return dao.getById(id);
    }

    @Override
    public List<Customer> getByIds(List<Long> ids) {
        return Collections.unmodifiableList(dao.getByIds(ids));
    }

    @Override
    public List<Customer> getAll() {
        return Collections.unmodifiableList(dao.getAll());
    }

    @Override
    public void update(Customer entity) {
        dao.update(entity);
    }

    @Override
    public void delete(Customer entity) {
        dao.delete(entity);
    }

    @Override
    public Customer create(String name) {
        return dao.create(new Customer(name));
    }

    @Override
    public List<Product> getProductsByCustomerId(Long id) {
        return Collections.unmodifiableList(
                productService.getByIds(dao.getProductsByCustomerId(id)));
    }

    @Override
    public List<OrderedProduct> getOrderedProductsByCustomerId(Long id) {
        return Collections.unmodifiableList(
                dao.getOrderedProductsByCustomerId(id));
    }
}
