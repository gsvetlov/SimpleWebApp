package ru.svetlov.webapp.service.impl;

import org.springframework.stereotype.Component;
import ru.svetlov.webapp.domain.Product;
import ru.svetlov.webapp.service.ProductRepository;
import ru.svetlov.webapp.service.ProductService;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public Product getProductById(long id) {
        return repository.getProductById(id);
    }

    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }
}
