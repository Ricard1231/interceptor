package com.example.interceptor.models;

public class OnButton implements Button {

    Player player;

    public OnButton(Player player) {
        this.player = player;
    }

    @Override
    public void press() {
        this.player.switchOn();
    }
}
