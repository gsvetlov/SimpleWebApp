package ru.svetlov.webapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.svetlov.webapp.config.AppConfig;
import ru.svetlov.webapp.console.ConsoleCartManager;
import ru.svetlov.webapp.console.ConsoleReader;
import ru.svetlov.webapp.service.Cart;


public class MainApp {
    private static AnnotationConfigApplicationContext context;

    public static void main(String[] args) {
        initialize();
        processCarts();
        context.close();
    }

    private static void processCarts() {
        ConsoleReader reader = context.getBean(ConsoleReader.class);
        do {
            Cart cart = context.getBean(Cart.class);
            System.out.printf("processing new cart: %s\n", cart);
            ConsoleCartManager manager = context.getBean(ConsoleCartManager.class);
            manager.process(cart);
            System.out.printf("cart processed...\n%s\ntype [exit] to finish or anything else to get another cart\n", cart);
        } while (!reader.readLine().equals("exit"));
    }

    private static void initialize() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
