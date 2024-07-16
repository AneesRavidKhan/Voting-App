package com.example.helloworld;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String message = (String) request.getAttribute("message");
        if (message == null) {
            message = "Hello World!";
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>" + message + "</h1></body></html>");
    }
}