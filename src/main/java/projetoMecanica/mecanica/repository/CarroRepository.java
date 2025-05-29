package projetoMecanica.mecanica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetoMecanica.mecanica.entidades.CarroEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CarroRepository extends JpaRepository<CarroEntity, Long> {
    Optional<CarroEntity> findByPlaca(String placa);
}
