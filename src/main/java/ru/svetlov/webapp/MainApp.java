package ru.svetlov.webapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.svetlov.webapp.config.AppConfig;
import ru.svetlov.webapp.domain.Customer;
import ru.svetlov.webapp.domain.OrderedProduct;
import ru.svetlov.webapp.domain.Product;
import ru.svetlov.webapp.service.CustomerService;
import ru.svetlov.webapp.service.ProductService;

import java.util.List;


public class MainApp {
    private static AnnotationConfigApplicationContext context;

    public static void main(String[] args) {
        initialize();
        testServices();
        context.close();
    }

    private static void testServices() {
        CustomerService customerService = context.getBean(CustomerService.class);
        List<Customer> customers = customerService.getAll();
        System.out.println(customers.get(1));
        List<Product> productsByCustomerId = customerService.getProductsByCustomerId(customers.get(1).getId());
        System.out.println(productsByCustomerId);

        ProductService productService = context.getBean(ProductService.class);
        List<Product> products = productService.getAll();
        List<Customer> productCustomers = productService.getProductCustomersById(products.get(1).getId());
        System.out.println(productCustomers);

        List<OrderedProduct> orderedProducts = customerService.getOrderedProductsByCustomerId(customers.get(2).getId());
        System.out.println(orderedProducts);
    }

    private static void initialize() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
