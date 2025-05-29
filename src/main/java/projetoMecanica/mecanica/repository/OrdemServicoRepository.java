package projetoMecanica.mecanica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetoMecanica.mecanica.entidades.OrdemServicoEntity;


@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServicoEntity, Long> {

}
