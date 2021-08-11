package ru.svetlov.webapp.service;

import ru.svetlov.webapp.domain.Customer;
import ru.svetlov.webapp.domain.Product;
import ru.svetlov.webapp.service.base.BaseServiceCrud;

import java.util.List;

public interface ProductService extends BaseServiceCrud<Product> {
    Product create(String title, double cost);
    List<Customer> getProductCustomersById(Long id);
}
