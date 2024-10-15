package com.mauriciogaspary.sarc_springboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mauriciogaspary.sarc_springboot.model.Disciplina;
import com.mauriciogaspary.sarc_springboot.service.SarcService;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private SarcService sarcService;

    public DisciplinaController(SarcService sarcService) {
        this.sarcService = sarcService;
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> listarDisciplinas() {
        List<Disciplina> disciplinas = sarcService.listarDisciplinas();
        return ResponseEntity.ok(disciplinas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscarDisciplinaPorId(@PathVariable("id") Long id) {
        Disciplina disciplina = sarcService.buscarDisciplinaPorId(id);
        if (disciplina != null) {
            return ResponseEntity.ok(disciplina);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Disciplina> criarDisciplina(@RequestBody Disciplina disciplina) {
        Disciplina novaDisciplina = sarcService.criarDisciplina(disciplina);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaDisciplina);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> atualizarDisciplina(
            @PathVariable Long id,
            @RequestBody Disciplina novaDisciplina) {
        Disciplina disciplinaAtualizada = sarcService.atualizarDisciplina(id, novaDisciplina);
        if (disciplinaAtualizada != null) {
            return ResponseEntity.ok(disciplinaAtualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
