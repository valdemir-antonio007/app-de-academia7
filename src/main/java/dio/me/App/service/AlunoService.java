package dio.me.App.service;

import dio.me.App.model.Aluno;

import java.util.List;

public interface AlunoService {
    List<Aluno> getAll();
    Aluno getOne(Long id);
    Aluno create(Aluno aluno);
    Aluno update(Long id, Aluno aluno);
    void delete(Long id);
}
