package ru.svetlov.webapp.repo;

import ru.svetlov.webapp.domain.Customer;
import ru.svetlov.webapp.domain.OrderedProduct;
import ru.svetlov.webapp.domain.Product;
import ru.svetlov.webapp.repo.base.BaseDao;

import java.util.List;

public interface CustomerDao extends BaseDao<Customer> {

    List<Long> getProductsByCustomerId(Long id);

    List<OrderedProduct> getOrderedProductsByCustomerId(Long id);
}
