package com.example.interceptor.models;

public class PlayButton implements Button {

    Player player;

    public PlayButton(Player player) {
        this.player = player;
    }

    @Override
    public void press() {
        this.player.play();
    }
}
