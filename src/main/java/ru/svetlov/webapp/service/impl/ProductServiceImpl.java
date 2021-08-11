package ru.svetlov.webapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.svetlov.webapp.domain.Customer;
import ru.svetlov.webapp.domain.Product;
import ru.svetlov.webapp.repo.ProductDao;
import ru.svetlov.webapp.service.CustomerService;
import ru.svetlov.webapp.service.ProductService;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDao dao;
    private final CustomerService customerService;

    @Autowired
    public ProductServiceImpl(ProductDao productDao, CustomerService customerService) {
        this.dao = productDao;
        this.customerService = customerService;
    }


    public Product create(String title, double cost) {
        return dao.create(new Product(title, BigDecimal.valueOf(cost)));
    }

    @Override
    public Product getById(Long id) {
        return dao.getById(id);
    }

    @Override
    public List<Product> getByIds(List<Long> ids) {
        return Collections.unmodifiableList(dao.getByIds(ids));
    }

    @Override
    public List<Product> getAll() {
        return Collections.unmodifiableList(dao.getAll());
    }

    @Override
    public void update(Product entity) {
        dao.update(entity);
    }

    @Override
    public void delete(Product entity) {
        dao.delete(entity);
    }

    @Override
    public List<Customer> getProductCustomersById(Long id) {
        return Collections.unmodifiableList(
                customerService.getByIds(dao.getProductCustomersById(id)));
    }
}
