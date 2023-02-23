package com.example.interceptor.controllers;

import com.example.interceptor.dispatchers.ChangeSongDispatcher;
import com.example.interceptor.dispatchers.Dispatcher;
import com.example.interceptor.dispatchers.PlayDispatcher;
import com.example.interceptor.dtos.SongDTO;
import com.example.interceptor.models.CDPlayer;
import com.example.interceptor.models.OnButton;
import com.example.interceptor.models.PauseButton;
import com.example.interceptor.models.PlayButton;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/cdplayer")
public class CDPlayerControllerImpl implements CDPlayerController{

    //There's usually a function to get player from database. For simplicity, a new CDPlayer will be declared every time the program is launched.
    CDPlayer player = new CDPlayer();
    PlayButton playButton = new PlayButton(player);
    PauseButton pauseButton = new PauseButton(player);
    OnButton onButton = new OnButton(player);

    @Override
    @GetMapping
    public ResponseEntity<?> getPlayer(HttpServletRequest request) {
        return ResponseEntity.ok(player);
    }

    @Override
    @GetMapping("/play")
    public ResponseEntity<?> play(HttpServletRequest request) {
        Dispatcher dispatcher = new PlayDispatcher(request, player);
        dispatcher.executeInterceptors();
        playButton.press();
        return ResponseEntity.ok(player);
    }

    @Override
    @GetMapping("/stop")
    public ResponseEntity<?> stop(HttpServletRequest request) {
        pauseButton.press();
        return ResponseEntity.ok(player);
    }

    @Override
    @GetMapping("/on")
    public ResponseEntity<?> on(HttpServletRequest request) {
        onButton.press();
        return ResponseEntity.ok(player);
    }

    @Override
    @PostMapping("/song")
    public ResponseEntity<?> song(HttpServletRequest request, @RequestBody SongDTO body) throws IOException {
        Dispatcher dispatcher = new ChangeSongDispatcher(request, player);
        dispatcher.executeInterceptors();
        player.setSong(body.getSong());
        return ResponseEntity.ok(player);
    }
}
