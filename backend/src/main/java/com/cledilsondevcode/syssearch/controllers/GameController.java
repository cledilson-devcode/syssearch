package com.cledilsondevcode.syssearch.controllers;

import com.cledilsondevcode.syssearch.dto.GameDTO;
import com.cledilsondevcode.syssearch.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameDTO>> findAll() {
        List<GameDTO> list = gameService.findAll();
        return ResponseEntity.ok().body(list);
    }

}
