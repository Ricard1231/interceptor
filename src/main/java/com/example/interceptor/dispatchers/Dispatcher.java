package com.example.interceptor.dispatchers;

import com.example.interceptor.interceptors.Interceptor;

public interface Dispatcher {

    void addInterceptor(Interceptor interceptor);

    void executeInterceptors();
}
