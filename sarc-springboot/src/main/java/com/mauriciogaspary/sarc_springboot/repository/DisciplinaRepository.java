package com.mauriciogaspary.sarc_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mauriciogaspary.sarc_springboot.model.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    
}
