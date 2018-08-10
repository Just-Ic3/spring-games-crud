package com.example.games.controllers;

import com.example.games.entities.GameEntity;
import com.example.games.repositories.GameRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
@CrossOrigin
public class GameController {

    private final GameRepository gameRepository;
    private final ObjectMapper mapper = new ObjectMapper();

    @PostMapping(consumes = "application/json", produces = "application/json")
    public GameEntity SaveGame(@RequestBody String form) {
        try {
            GameEntity gameEntity = mapper.readValue(form,GameEntity.class);
            gameRepository.save(gameEntity);
            return gameEntity;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public GameEntity GetGame(@PathVariable(name = "id") String id) {
        GameEntity gameEntity = gameRepository.findOneByIdEquals(id);
        if (gameEntity == null) {
            throw new RuntimeException();
        }
        return gameEntity;
    }
}
