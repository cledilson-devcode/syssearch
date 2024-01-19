package com.cledilsondevcode.syssearch.controllers;

import com.cledilsondevcode.syssearch.dto.RecordDTO;
import com.cledilsondevcode.syssearch.dto.RecordInsertDTO;
import com.cledilsondevcode.syssearch.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/records")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @PostMapping
    public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO dto){
        RecordDTO newDTO = recordService.insert(dto);

        return ResponseEntity.ok().body(newDTO);
    }

}
