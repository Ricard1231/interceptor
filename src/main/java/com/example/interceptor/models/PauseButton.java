package com.example.interceptor.models;

public class PauseButton implements Button{
    Player player;

    public PauseButton(Player player) {
        this.player = player;
    }

    @Override
    public void press() {
        this.player.stop();
    }
}
