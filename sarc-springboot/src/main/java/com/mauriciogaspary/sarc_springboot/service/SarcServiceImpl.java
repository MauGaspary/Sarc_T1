package com.mauriciogaspary.sarc_springboot.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mauriciogaspary.sarc_springboot.model.Disciplina;
import com.mauriciogaspary.sarc_springboot.model.Professor;
import com.mauriciogaspary.sarc_springboot.model.Recurso;
import com.mauriciogaspary.sarc_springboot.model.Turma;
import com.mauriciogaspary.sarc_springboot.repository.DisciplinaRepository;
import com.mauriciogaspary.sarc_springboot.repository.ProfessorRepository;
import com.mauriciogaspary.sarc_springboot.repository.RecursoRepository;
import com.mauriciogaspary.sarc_springboot.repository.TurmaRepository;

@Service
public class SarcServiceImpl implements SarcService {

    private final DisciplinaRepository disciplinaRepository;
    private final ProfessorRepository professorRepository;
    private final TurmaRepository turmaRepository;
    private final RecursoRepository recursoRepository;

    public SarcServiceImpl(
            DisciplinaRepository disciplinaRepository, 
            ProfessorRepository professorRepository,
            TurmaRepository turmaRepository,
            RecursoRepository recursoRepository) {
        this.disciplinaRepository = disciplinaRepository;
        this.professorRepository = professorRepository;
        this.turmaRepository = turmaRepository;
        this.recursoRepository = recursoRepository;
    }

    // Disciplinas
    @Override
    public List<Disciplina> listarDisciplinas() {
        return disciplinaRepository.findAll();
    }

    @Override
    public Disciplina buscarDisciplinaPorId(Long id) {
        return disciplinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));
    }

    @Override
    public Disciplina criarDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    @Override
    public Disciplina atualizarDisciplina(Long id, Disciplina novaDisciplina) {
        Disciplina disciplina = buscarDisciplinaPorId(id);
        disciplina.setNome(novaDisciplina.getNome());
        disciplina.setCargaHoraria(novaDisciplina.getCargaHoraria());
        disciplina.setTurma(novaDisciplina.getTurma());
        return disciplinaRepository.save(disciplina);
    }

    // Professores
    @Override
    public List<Professor> listarProfessores() {
        return professorRepository.findAll();
    }

    @Override
    public Professor buscarProfessorPorId(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
    }

    @Override
    public Professor criarProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Professor atualizarProfessor(Long id, Professor novoProfessor) {
        Professor professor = buscarProfessorPorId(id);
        professor.setNome(novoProfessor.getNome());
        professor.setEmail(novoProfessor.getEmail());
        return professorRepository.save(professor);
    }

    // Turmas
    @Override
    public List<Turma> listarTurmas() {
        return turmaRepository.findAll();
    }

    @Override
    public Turma buscarTurmaPorId(Long id) {
        return turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
    }

    @Override
    public Turma criarTurma(Turma turma) {
        return turmaRepository.save(turma);
    }

    @Override
    public Turma atualizarTurma(Long id, Turma novaTurma) {
        Turma turma = buscarTurmaPorId(id);
        turma.setHorario(novaTurma.getHorario());
        turma.setProfessor(novaTurma.getProfessor());
        return turmaRepository.save(turma);
    }

    // Recursos
    @Override
    public List<Recurso> listarRecursos() {
        return recursoRepository.findAll();
    }

    @Override
    public Recurso buscarRecursoPorId(Long id) {
        return recursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
    }

    @Override
    public Recurso criarRecurso(Recurso recurso) {
        return recursoRepository.save(recurso);
    }

    @Override
    public Recurso atualizarRecurso(Long id, Recurso novoRecurso) {
        Recurso recurso = buscarRecursoPorId(id);
        recurso.setDescricao(novoRecurso.getDescricao());
        return recursoRepository.save(recurso);
    }
}
