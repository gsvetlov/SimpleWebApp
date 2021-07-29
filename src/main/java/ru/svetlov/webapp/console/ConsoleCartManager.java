package ru.svetlov.webapp.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.svetlov.webapp.domain.Product;
import ru.svetlov.webapp.service.Cart;

import java.util.List;

@Component
public class ConsoleCartManager {
    private final ConsoleReader reader;

    @Autowired
    public ConsoleCartManager(ConsoleReader reader) {
        this.reader = reader;
    }

    public void process(Cart cart) {
        System.out.println("type [exit] or [close] or [0] to exit\n[list] to get cart contents\n[+x] to add item[x] to cart,\n[-x] to remove item[x] from cart");

            boolean isProcessing;
            do {
                isProcessing = true;
                String input = reader.readLine();
                switch (input) {
                    case "exit":
                    case "close": {
                        isProcessing = false;
                        break;
                    }
                    case "list": {
                        displayCart(cart.getContents());
                        break;
                    }
                    default:
                        isProcessing = cartAction(cart, parseConsole(input));
                        break;
                }
            } while (isProcessing);

    }

    private long parseConsole(String input) throws NumberFormatException {
        return Long.parseLong(input);
    }

    private boolean cartAction(Cart cart, long action) {
        if (action == 0) return false;
        if (action > 0) {
            cart.addItem(action - 1);
        } else {
            cart.removeItem(Math.abs(action + 1));
        }
        return true;
    }

    private void displayCart(List<Product> cart){
        System.out.println(cart);
    }

}
