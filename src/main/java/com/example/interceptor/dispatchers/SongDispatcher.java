package com.example.interceptor.dispatchers;

import com.example.interceptor.interceptors.Interceptor;
import com.example.interceptor.interceptors.LoggingInterceptor;
import com.example.interceptor.interceptors.SongInterceptor;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SongDispatcher implements Dispatcher{

    private List<Interceptor> interceptors;

    private HttpServletRequest request;

    public SongDispatcher(HttpServletRequest request) {
        this.interceptors = new ArrayList<>();
        this.request = request;
        addInterceptor(new LoggingInterceptor());
        addInterceptor(new SongInterceptor());
    }

    @Override
    public void addInterceptor(Interceptor interceptor) {
        this.interceptors.add(interceptor);
    }

    @Override
    public void executeInterceptors() {
        this.interceptors.forEach(interceptor -> {
            try {
                interceptor.processRequest(this.request);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
