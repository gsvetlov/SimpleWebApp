package ru.svetlov.webapp.service;

import ru.svetlov.webapp.domain.Customer;
import ru.svetlov.webapp.domain.OrderedProduct;
import ru.svetlov.webapp.domain.Product;
import ru.svetlov.webapp.service.base.BaseServiceCrud;

import java.util.List;

public interface CustomerService extends BaseServiceCrud<Customer> {

    Customer create(String name);

    List<Product> getProductsByCustomerId(Long id);

    List<OrderedProduct> getOrderedProductsByCustomerId(Long id);

}
