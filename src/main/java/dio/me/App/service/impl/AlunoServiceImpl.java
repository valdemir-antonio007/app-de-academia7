package dio.me.App.service.impl;

import dio.me.App.model.Aluno;
import dio.me.App.repository.AlunoRepository;
import dio.me.App.service.AlunoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno getOne(Long id) {
        return alunoRepository.findById(id).get();
    }

    @Override
    public Aluno create(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno update(Long id, Aluno aluno) {
        Aluno a = alunoRepository.findById(id).get();
        a.setNome(aluno.getNome());
        a.setCpf(aluno.getCpf());
        a.setBairro(aluno.getBairro());
        a.setDataNascimento(aluno.getDataNascimento());
        return alunoRepository.save(a);
    }

    @Override
    public void delete(Long id) {
        alunoRepository.deleteById(id);
    }
}
