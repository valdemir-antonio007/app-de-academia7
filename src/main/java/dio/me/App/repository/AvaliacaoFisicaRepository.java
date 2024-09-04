package dio.me.App.repository;

import dio.me.App.model.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long> {
    @Query(value = "select * from tb_avaliacoes where tb_avaliacoes.aluno_id = :alunoId", nativeQuery = true)
    List<AvaliacaoFisica> getAllAvaliacoesPorAluno(Long alunoId);
}
