package dio.me.App.service;

import dio.me.App.model.Matricula;

import java.util.List;

public interface MatriculaService {
    List<Matricula> getAll();
    Matricula getOne(Long id);
    Matricula create(Long alunoId);
    void delete(Long id);
}
