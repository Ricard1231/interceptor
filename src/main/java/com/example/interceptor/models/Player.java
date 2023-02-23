package com.example.interceptor.models;

import com.example.interceptor.models.enumerations.PlayerState;

public interface Player {
    PlayerState getCurrentState();
    void setCurrentState(PlayerState state);

    void switchOn();

    void switchOff();

    void play();

    void stop();

    String getSong();
}
