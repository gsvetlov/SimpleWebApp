package ru.svetlov.webapp.service;

import ru.svetlov.webapp.domain.Product;

import java.util.List;

public interface Cart {
    void removeItem(long id);

    void addItem(long id);

    List<Product> getContents();
}
