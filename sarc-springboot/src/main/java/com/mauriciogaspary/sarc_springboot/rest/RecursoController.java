package com.mauriciogaspary.sarc_springboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mauriciogaspary.sarc_springboot.model.Recurso;
import com.mauriciogaspary.sarc_springboot.service.SarcService;

@RestController
@RequestMapping("/recursos")
public class RecursoController {

    @Autowired
    private SarcService sarcService;

    public RecursoController(SarcService sarcService) {
        this.sarcService = sarcService;
    }

    @GetMapping
    public ResponseEntity<List<Recurso>> listarRecursos() {
        List<Recurso> recursos = sarcService.listarRecursos();
        return ResponseEntity.ok(recursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recurso> buscarRecursoPorId(@PathVariable Long id) {
        Recurso recurso = sarcService.buscarRecursoPorId(id);
        if (recurso != null) {
            return ResponseEntity.ok(recurso);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Recurso> criarRecurso(@RequestBody Recurso recurso) {
        Recurso novoRecurso = sarcService.criarRecurso(recurso);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoRecurso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recurso> atualizarRecurso(
            @PathVariable Long id,
            @RequestBody Recurso novoRecurso) {
        Recurso recursoAtualizado = sarcService.atualizarRecurso(id, novoRecurso);
        if (recursoAtualizado != null) {
            return ResponseEntity.ok(recursoAtualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
