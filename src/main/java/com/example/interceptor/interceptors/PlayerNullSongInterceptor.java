package com.example.interceptor.interceptors;

import com.example.interceptor.models.PlayerContextObject;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class PlayerNullSongInterceptor implements PlayerInterceptor {
    @Override
    public void processRequest(HttpServletRequest request, PlayerContextObject contextObject) throws IOException {
        if (contextObject.getSong() == null) {
            throw new IOException("Player has no song, cannot proceed with request");
        }
    }
}
