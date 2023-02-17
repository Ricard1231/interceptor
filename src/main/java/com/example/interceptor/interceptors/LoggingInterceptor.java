package com.example.interceptor.interceptors;

import jakarta.servlet.http.HttpServletRequest;

public class LoggingInterceptor implements Interceptor{

    @Override
    public void processRequest(HttpServletRequest request) {
        System.out.println("URL: " + request.getRequestURL());
    }
}
