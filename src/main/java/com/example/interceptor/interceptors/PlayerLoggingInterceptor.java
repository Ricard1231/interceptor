package com.example.interceptor.interceptors;

import com.example.interceptor.models.PlayerContextObject;
import jakarta.servlet.http.HttpServletRequest;

public class PlayerLoggingInterceptor implements PlayerInterceptor {

    @Override
    public void processRequest(HttpServletRequest request, PlayerContextObject contextObject) {
        System.out.println("URL: " + request.getRequestURL());
        System.out.println("Player state changed from " + contextObject.getCurrentState().name());
    }
}
