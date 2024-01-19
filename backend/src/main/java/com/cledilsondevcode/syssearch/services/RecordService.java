package com.cledilsondevcode.syssearch.services;

import com.cledilsondevcode.syssearch.dto.GameDTO;
import com.cledilsondevcode.syssearch.dto.RecordDTO;
import com.cledilsondevcode.syssearch.dto.RecordInsertDTO;
import com.cledilsondevcode.syssearch.entities.Game;
import com.cledilsondevcode.syssearch.entities.Record;
import com.cledilsondevcode.syssearch.repositories.GameRepository;
import com.cledilsondevcode.syssearch.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public List<RecordDTO> findAll(){
        List<Record> list = recordRepository.findAll();
        return list.stream().map(x -> new RecordDTO(x)).collect(Collectors.toList());

    }

    @Transactional
    public Page<RecordDTO> findByMoments(Instant minDate, Instant maxDate, PageRequest pageRequest) {
        return recordRepository.findByMoments(minDate, maxDate, pageRequest).map(x -> new RecordDTO(x));
    }
}
