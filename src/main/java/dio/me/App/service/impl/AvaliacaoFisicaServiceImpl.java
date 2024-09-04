package dio.me.App.service.impl;

import dio.me.App.model.Aluno;
import dio.me.App.model.AvaliacaoFisica;
import dio.me.App.repository.AlunoRepository;
import dio.me.App.repository.AvaliacaoFisicaRepository;
import dio.me.App.service.AvaliacaoFisicaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements AvaliacaoFisicaService {
    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    private final AlunoRepository alunoRepository;

    public AvaliacaoFisicaServiceImpl(AvaliacaoFisicaRepository avaliacaoFisicaRepository, AlunoRepository alunoRepository) {
        this.avaliacaoFisicaRepository = avaliacaoFisicaRepository;
        this.alunoRepository = alunoRepository;
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica getOne(Long id) {
        return avaliacaoFisicaRepository.findById(id).get();
    }

    @Override
    public AvaliacaoFisica create(Long alunoId, AvaliacaoFisica avaliacao) {
        Aluno a =  alunoRepository.findById(alunoId).get();
        avaliacao.setAluno(a);
        return avaliacaoFisicaRepository.save(avaliacao);
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisica avaliacao) {
        AvaliacaoFisica af = avaliacaoFisicaRepository.findById(id).get();
        af.setPeso(avaliacao.getPeso());
        af.setAltura(avaliacao.getAltura());
        return avaliacaoFisicaRepository.save(af);
    }

    @Override
    public void delete(Long id) {
        avaliacaoFisicaRepository.deleteById(id);
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacoesPorAluno(Long alunoId) {
        return avaliacaoFisicaRepository.getAllAvaliacoesPorAluno(alunoId);
    }
}
