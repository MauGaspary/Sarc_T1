package com.mauriciogaspary.sarc_springboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mauriciogaspary.sarc_springboot.model.Turma;
import com.mauriciogaspary.sarc_springboot.service.SarcService;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private SarcService sarcService;

    public TurmaController(SarcService sarcService) {
        this.sarcService = sarcService;
    }

    @GetMapping
    public ResponseEntity<List<Turma>> listarTurmas() {
        List<Turma> turmas = sarcService.listarTurmas();
        return ResponseEntity.ok(turmas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscarTurmaPorId(@PathVariable Long id) {
        Turma turma = sarcService.buscarTurmaPorId(id);
        if (turma != null) {
            return ResponseEntity.ok(turma);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Turma> criarTurma(@RequestBody Turma turma) {
        Turma novaTurma = sarcService.criarTurma(turma);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTurma);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> atualizarTurma(
            @PathVariable Long id,
            @RequestBody Turma novaTurma) {
        Turma turmaAtualizada = sarcService.atualizarTurma(id, novaTurma);
        if (turmaAtualizada != null) {
            return ResponseEntity.ok(turmaAtualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
