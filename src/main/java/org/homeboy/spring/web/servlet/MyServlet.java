package org.homeboy.spring.web.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet 3.0  实现方式
 */
@WebServlet(urlPatterns = "/my/servlet",
asyncSupported = true)
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        AsyncContext context = req.startAsync();
        context.start(()->{
            try {
                resp.getWriter().println("hello D.Rose");
                context.complete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        resp.getWriter().println("hello world!");
    }
}
