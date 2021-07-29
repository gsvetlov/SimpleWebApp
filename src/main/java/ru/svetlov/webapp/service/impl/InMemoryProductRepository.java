package ru.svetlov.webapp.service.impl;

import org.springframework.stereotype.Component;
import ru.svetlov.webapp.domain.Product;
import ru.svetlov.webapp.service.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class InMemoryProductRepository implements ProductRepository {
    private static Product NULL_PRODUCT;
    private List<Product> products;

    @Override
    public Product getProductById(long id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(NULL_PRODUCT);
    }

    @Override
    public List<Product> getAll() {
        return Collections.unmodifiableList(products);
    }

    @PostConstruct
    private void init() {
        NULL_PRODUCT = new Product(0, "Product missing", 0);
        products = new ArrayList<>(Arrays.asList(
                new Product(1, "Product A", 12.10),
                new Product(2, "Product B", 23.45),
                new Product(3, "Product C", 34.95),
                new Product(4, "Product D", 45.95),
                new Product(5, "Product E", 7.40)
        ));
    }
}
