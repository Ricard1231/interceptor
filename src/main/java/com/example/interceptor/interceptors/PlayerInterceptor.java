package com.example.interceptor.interceptors;

import com.example.interceptor.models.PlayerContextObject;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public interface PlayerInterceptor {

    void processRequest(HttpServletRequest request, PlayerContextObject contextObject) throws IOException;
}
