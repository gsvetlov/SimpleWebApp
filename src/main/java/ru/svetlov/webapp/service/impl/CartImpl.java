package ru.svetlov.webapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.svetlov.webapp.domain.Product;
import ru.svetlov.webapp.service.Cart;
import ru.svetlov.webapp.service.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope(scopeName = "prototype")
public class CartImpl implements Cart {
    private final ProductRepository productRepository;
    private List<Product> cartContents;

    @Autowired
    public CartImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void removeItem(long id){
        Product product = productRepository.getProductById(id);
        cartContents.remove(product);
    }

    @Override
    public void addItem(long id){
        Product product = productRepository.getProductById(id);
        if (product.getId() == id){
            cartContents.add(product);
        }
    }

    @Override
    public List<Product> getContents() {
        return Collections.unmodifiableList(cartContents);
    }

    @PostConstruct
    private void init(){
        cartContents = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "CartImpl{" +
                "cartContents=" + cartContents +
                '}';
    }
}
