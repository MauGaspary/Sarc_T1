package com.mauriciogaspary.sarc_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mauriciogaspary.sarc_springboot.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
}
