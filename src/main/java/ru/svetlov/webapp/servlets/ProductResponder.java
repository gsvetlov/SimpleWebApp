package ru.svetlov.webapp.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.svetlov.webapp.domain.Product;
import ru.svetlov.webapp.factory.Factory;
import ru.svetlov.webapp.service.ProductInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProductPage", urlPatterns = "/products")
public class ProductResponder extends HttpServlet {
    private static final Logger log = LogManager.getLogger(ProductResponder.class);
    private ProductInfoService productInfo;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("Request from {}:{}", req.getRemoteAddr(), req.getRemotePort());
        req.setAttribute("productList", productInfo.getProducts(10));
        req.getRequestDispatcher("/products.jsp").forward(req, resp);
        log.info("Forwarding with {}", resp.getStatus());
    }

    @Override
    public void init() throws ServletException {
        productInfo = Factory.getProductInfoService();
        if (productInfo == null) {
            throw new ServletException();
        }
    }
}
