package com.example.helloworld;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class HelloWorldServletTest {
    private HelloWorldServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;

    @BeforeEach
    public void setup() {
        servlet = new HelloWorldServlet();
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
    }

    @Test
    public void testDoGet() throws IOException {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);

        servlet.doGet(request, response);

        assertTrue(stringWriter.toString().contains("Hello World"));
    }

    @Test
    public void testDoGetWithCustomMessage() throws IOException {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);
        when(request.getAttribute("message")).thenReturn("Custom Message");

        servlet.doGet(request, response);

        assertTrue(stringWriter.toString().contains("Custom Message"));
    }

    @Test
    public void testDoGetWithNullMessage() throws IOException {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);
        when(request.getAttribute("message")).thenReturn(null);

        servlet.doGet(request, response);

        assertTrue(stringWriter.toString().contains("Hello World"));
    }
}