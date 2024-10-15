package com.mauriciogaspary.sarc_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mauriciogaspary.sarc_springboot.model.Recurso;

public interface RecursoRepository extends JpaRepository<Recurso, Long> {
    
}
