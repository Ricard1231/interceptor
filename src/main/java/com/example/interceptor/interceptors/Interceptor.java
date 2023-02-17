package com.example.interceptor.interceptors;

import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public interface Interceptor {

    void processRequest(HttpServletRequest request) throws IOException;
}
