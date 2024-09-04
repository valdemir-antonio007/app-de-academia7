package dio.me.App.repository;

import dio.me.App.model.AvaliacaoFisica;
import dio.me.App.model.Matricula;
import dio.me.App.service.impl.MatriculaServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
