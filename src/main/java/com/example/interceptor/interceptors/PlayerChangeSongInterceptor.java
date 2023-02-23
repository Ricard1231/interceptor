package com.example.interceptor.interceptors;

import com.example.interceptor.models.PlayerContextObject;
import jakarta.servlet.http.HttpServletRequest;

public class PlayerChangeSongInterceptor implements PlayerInterceptor {
    @Override
    public void processRequest(HttpServletRequest request, PlayerContextObject contextObject) {

        System.out.println("Song changed from " + contextObject.getSong());

    }
}
