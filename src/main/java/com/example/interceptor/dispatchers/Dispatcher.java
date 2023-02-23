package com.example.interceptor.dispatchers;

import com.example.interceptor.interceptors.PlayerInterceptor;

public interface Dispatcher {

    void addInterceptor(PlayerInterceptor playerInterceptor);

    void executeInterceptors();
}
