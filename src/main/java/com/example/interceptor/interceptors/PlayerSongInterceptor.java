package com.example.interceptor.interceptors;

import com.example.interceptor.models.PlayerContextObject;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class PlayerSongInterceptor implements PlayerInterceptor {
    @Override
    public void processRequest(HttpServletRequest request, PlayerContextObject contextObject) throws IOException {

        System.out.println("Song changed from " + contextObject.getSong());

    }
}
