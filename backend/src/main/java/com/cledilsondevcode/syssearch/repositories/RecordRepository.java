package com.cledilsondevcode.syssearch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cledilsondevcode.syssearch.entities.Record;


@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {



}
