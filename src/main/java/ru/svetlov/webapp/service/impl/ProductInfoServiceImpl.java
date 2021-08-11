package ru.svetlov.webapp.service.impl;

import ru.svetlov.webapp.domain.Product;
import ru.svetlov.webapp.service.ProductInfoService;
import ru.svetlov.webapp.service.util.RndGen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductInfoServiceImpl implements ProductInfoService {
    @Override
    public List<Product> getProducts(int count) {
        List<Product> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(new Product(
                    i,
                    String.format("Product - %d", i),
                    RndGen.getNextDouble(1, 150))
            );
        }
        return Collections.unmodifiableList(list);
    }
}
