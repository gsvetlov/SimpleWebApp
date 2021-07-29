package ru.svetlov.webapp.service;

import ru.svetlov.webapp.domain.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(long id);

    List<Product> getAll();
}
