package com.example.interceptor.controllers;

import com.example.interceptor.dtos.SongDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface CDPlayerController {

    ResponseEntity<?> getPlayer(HttpServletRequest request);

    ResponseEntity<?> play(HttpServletRequest request);

    ResponseEntity<?> stop(HttpServletRequest request);

    ResponseEntity<?> song(HttpServletRequest request, SongDTO body) throws IOException;
}
