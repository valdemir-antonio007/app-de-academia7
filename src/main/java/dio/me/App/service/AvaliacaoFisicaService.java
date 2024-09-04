package dio.me.App.service;

import dio.me.App.model.AvaliacaoFisica;

import java.util.List;

public interface AvaliacaoFisicaService {
    List<AvaliacaoFisica> getAll();
    AvaliacaoFisica getOne(Long id);
    AvaliacaoFisica create(Long alunoId, AvaliacaoFisica avaliacao);
    AvaliacaoFisica update(Long id, AvaliacaoFisica avaliacao);
    void delete(Long id);
    List<AvaliacaoFisica> getAllAvaliacoesPorAluno(Long alunoId);
}
