package projetoMecanica.mecanica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetoMecanica.mecanica.entidades.ClienteEntity;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
