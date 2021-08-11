package ru.svetlov.webapp.repo;

import ru.svetlov.webapp.domain.Customer;
import ru.svetlov.webapp.domain.Product;
import ru.svetlov.webapp.repo.base.BaseDao;

import java.util.List;

public interface ProductDao extends BaseDao<Product> {
    List<Long> getProductCustomersById(Long id);
}
