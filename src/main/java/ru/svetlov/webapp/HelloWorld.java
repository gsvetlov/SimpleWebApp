package ru.svetlov.webapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Stream;

public class HelloWorld extends HttpServlet {

    private static final Logger log = LogManager.getLogger();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("incoming request");
        log.info(req);
        Stream.of(req.getHeaderNames()).forEach(System.out::println);
        //resp.setStatus(200);
        //resp.setHeader("Content-Type", "text/html; charset=utf-8");
        log.info("responding");
        resp.getWriter().println("<html><body><h1>Hello world!</h1><h2> user</h2></body></html>");
        log.info(resp);
    }
}
