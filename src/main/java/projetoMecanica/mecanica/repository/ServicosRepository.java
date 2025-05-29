package projetoMecanica.mecanica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetoMecanica.mecanica.entidades.ServicosEntity;


@Repository
public interface ServicosRepository extends JpaRepository<ServicosEntity, Long> {
}
