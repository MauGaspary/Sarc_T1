package com.mauriciogaspary.sarc_springboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mauriciogaspary.sarc_springboot.model.Professor;
import com.mauriciogaspary.sarc_springboot.service.SarcService;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private SarcService sarcService;

    public ProfessorController(SarcService sarcService) {
        this.sarcService = sarcService;
    }

    @GetMapping
    public ResponseEntity<List<Professor>> listarProfessores() {
        List<Professor> professores = sarcService.listarProfessores();
        return ResponseEntity.ok(professores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarProfessorPorId(@PathVariable("id") Long id) {
        Professor professor = sarcService.buscarProfessorPorId(id);
        if (professor != null) {
            return ResponseEntity.ok(professor);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Criar novo professor
    @PostMapping
    public ResponseEntity<Professor> criarProfessor(@RequestBody Professor professor) {
        Professor novoProfessor = sarcService.criarProfessor(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProfessor);
    }

    // Atualizar professor por ID
    @PutMapping("/{id}")
    public ResponseEntity<Professor> atualizarProfessor(
            @PathVariable Long id, 
            @RequestBody Professor professorAtualizado) {
        Professor professor = sarcService.atualizarProfessor(id, professorAtualizado);
        if (professor != null) {
            return ResponseEntity.ok(professor);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
