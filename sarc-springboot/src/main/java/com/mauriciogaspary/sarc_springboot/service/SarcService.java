package com.mauriciogaspary.sarc_springboot.service;

import java.util.List;

import com.mauriciogaspary.sarc_springboot.model.Disciplina;
import com.mauriciogaspary.sarc_springboot.model.Professor;
import com.mauriciogaspary.sarc_springboot.model.Recurso;
import com.mauriciogaspary.sarc_springboot.model.Turma;

public interface SarcService {

    List<Disciplina> listarDisciplinas();
    Disciplina buscarDisciplinaPorId(Long id);
    Disciplina criarDisciplina(Disciplina disciplina); 
    Disciplina atualizarDisciplina(Long id, Disciplina novaDisciplina);

    List<Professor> listarProfessores();
    Professor buscarProfessorPorId(Long id);
    Professor criarProfessor(Professor professor);
    Professor atualizarProfessor(Long id, Professor novoProfessor);

    List<Turma> listarTurmas();
    Turma buscarTurmaPorId(Long id);
    Turma criarTurma(Turma turma);
    Turma atualizarTurma(Long id, Turma novaTurma);

    List<Recurso> listarRecursos();
    Recurso buscarRecursoPorId(Long id);
    Recurso criarRecurso(Recurso recurso);
    Recurso atualizarRecurso(Long id, Recurso novoRecurso);
}
