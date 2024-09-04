package dio.me.App.service.impl;

import dio.me.App.model.Aluno;
import dio.me.App.model.Matricula;
import dio.me.App.repository.AlunoRepository;
import dio.me.App.repository.MatriculaRepository;
import dio.me.App.service.MatriculaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements MatriculaService {
    private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;

    public MatriculaServiceImpl(MatriculaRepository matriculaRepository, AlunoRepository alunoRepository) {
        this.matriculaRepository = matriculaRepository;
        this.alunoRepository = alunoRepository;
    }

    @Override
    public List<Matricula> getAll() {
        return matriculaRepository.findAll();
    }

    @Override
    public Matricula getOne(Long id) {
        return matriculaRepository.findById(id).get();
    }

    @Override
    public Matricula create(Long alunoId) {
        Aluno a = alunoRepository.findById(alunoId).get();
        Matricula m = new Matricula();
        m.setAluno(a);
        return matriculaRepository.save(m);
    }

    @Override
    public void delete(Long id) {
            matriculaRepository.deleteById(id);
    }
}
