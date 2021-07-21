package ru.svetlov.webapp.service;

import ru.svetlov.webapp.domain.Product;

import java.util.List;

public interface ProductInfoService {
    List<Product> getProducts(int count);
}
