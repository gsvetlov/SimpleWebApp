package ru.svetlov.webapp.service;

import ru.svetlov.webapp.domain.Product;

import java.util.List;

public interface ProductRepository {
    Product getProductById(long id);

    List<Product> getAll();
}
