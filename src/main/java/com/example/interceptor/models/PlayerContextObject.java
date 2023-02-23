package com.example.interceptor.models;

import com.example.interceptor.models.enumerations.PlayerState;

public class PlayerContextObject {
    Player player;

    public PlayerContextObject(Player player) {
        this.player = player;
    }

    public String getSong() {
        return this.player.getSong();
    }

    public PlayerState getCurrentState() {
        return this.player.getCurrentState();
    }
}
