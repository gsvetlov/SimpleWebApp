package ru.svetlov.webapp.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Stream;

public class HelloWorld extends HttpServlet {

    private static final Logger log = LogManager.getLogger(HelloWorld.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log.info("Request from {}:{}", req.getRemoteAddr(), req.getRemotePort());
        resp.getWriter().println("<html><body><h1>Hello!</h1><br/><h2>from Simple Web App</h2></body></html>");
        log.info("Responding with {}", resp.getStatus());
    }
}
