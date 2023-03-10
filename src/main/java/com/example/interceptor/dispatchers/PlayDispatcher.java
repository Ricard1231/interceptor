package com.example.interceptor.dispatchers;

import com.example.interceptor.interceptors.PlayerInterceptor;
import com.example.interceptor.interceptors.PlayerLoggingInterceptor;
import com.example.interceptor.interceptors.PlayerNullSongInterceptor;
import com.example.interceptor.models.Player;
import com.example.interceptor.models.PlayerContextObject;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayDispatcher implements Dispatcher{

    private List<PlayerInterceptor> playerInterceptors;

    private HttpServletRequest request;

    private PlayerContextObject contextObject;

    public PlayDispatcher(HttpServletRequest request, Player player) {
        this.playerInterceptors = new ArrayList<>();
        this.request = request;
        this.contextObject = new PlayerContextObject(player);
        addInterceptor(new PlayerNullSongInterceptor());
        addInterceptor(new PlayerLoggingInterceptor());
    }

    @Override
    public void addInterceptor(PlayerInterceptor playerInterceptor) {
        this.playerInterceptors.add(playerInterceptor);
    }

    @Override
    public void executeInterceptors() {
        this.playerInterceptors.forEach(interceptor -> {
            try {
                interceptor.processRequest(this.request, this.contextObject);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
