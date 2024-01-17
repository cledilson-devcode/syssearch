package com.cledilsondevcode.syssearch.services;

import com.cledilsondevcode.syssearch.dto.GameDTO;
import com.cledilsondevcode.syssearch.entities.Game;
import com.cledilsondevcode.syssearch.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameDTO> findAll(){
        List<Game> list = gameRepository.findAll();
        return list.stream().map(x -> new GameDTO(x)).collect(Collectors.toList());

    }

}
