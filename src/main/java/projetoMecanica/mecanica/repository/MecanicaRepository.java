package projetoMecanica.mecanica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetoMecanica.mecanica.entidades.MecanicaEntity;

import java.util.UUID;

@Repository
public interface MecanicaRepository extends JpaRepository<MecanicaEntity, Long> {
}
