package com.cledilsondevcode.syssearch.repositories;

import com.cledilsondevcode.syssearch.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {



}
