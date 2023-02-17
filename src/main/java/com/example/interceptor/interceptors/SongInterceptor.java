package com.example.interceptor.interceptors;

import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class SongInterceptor implements Interceptor{
    @Override
    public void processRequest(HttpServletRequest request) throws IOException {

        System.out.println(System.currentTimeMillis());
        System.out.println(request.getHeaderNames());

//        String requestBody = "";
//        if ("POST".equalsIgnoreCase(request.getMethod())) {
//            Scanner s = new Scanner(request.getInputStream(), "UTF-8").useDelimiter("\\A");
//            requestBody = s.hasNext() ? s.next() : "";
//        }
//        System.out.println(requestBody);
    }
}
