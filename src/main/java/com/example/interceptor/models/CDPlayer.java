package com.example.interceptor.models;

import com.example.interceptor.models.enumerations.PlayerState;

public class CDPlayer implements Player{

    private PlayerState currentState = PlayerState.OFF;

    private String song;

    @Override
    public PlayerState getCurrentState() {
        return this.currentState;
    }

    @Override
    public void setCurrentState(PlayerState state) {
        this.currentState = state;
    }

    public void setSong(String song) {
        this.song = song;
    }

    @Override
    public void switchOn() {
        this.currentState = PlayerState.ON;
    }

    @Override
    public void switchOff() {
        this.currentState = PlayerState.OFF;
    }

    @Override
    public void play() {
        this.currentState = PlayerState.PLAYING;
    }

    @Override
    public void stop() {
        this.currentState = PlayerState.PAUSED;
    }

    @Override
    public String getSong() {
        return this.song;
    }
}
