package com.cledilsondevcode.syssearch.services;

import com.cledilsondevcode.syssearch.dto.RecordDTO;
import com.cledilsondevcode.syssearch.dto.RecordInsertDTO;
import com.cledilsondevcode.syssearch.entities.Game;
import com.cledilsondevcode.syssearch.entities.Record;
import com.cledilsondevcode.syssearch.repositories.GameRepository;
import com.cledilsondevcode.syssearch.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public RecordDTO insert(RecordInsertDTO dto){
        Record entity = new Record();

        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setMoment(Instant.now());
        Game game = gameRepository.getReferenceById(dto.getGameId());
        entity.setGame(game);

        entity = recordRepository.save(entity);

        return new RecordDTO(entity);
    }

}
