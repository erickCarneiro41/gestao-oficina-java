package projetoMecanica.mecanica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoMecanica.mecanica.entidades.CarroEntity;
import projetoMecanica.mecanica.repository.CarroRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceCarro {

    @Autowired
    private CarroRepository carroRepository;

    public CarroEntity adicionarCarro(CarroEntity carro) {
        if (carro == null) {
            throw new IllegalArgumentException("A entidade Carro não pode ser nula.");
        }

        if (carro.getCliente() == null || carro.getPlaca() == null || carro.getPlaca().isEmpty()) {
            throw new IllegalArgumentException("O cliente e a placa não podem ser nulos ou vazios.");
        }

        Optional<CarroEntity> carroExistente = carroRepository.findByPlaca(carro.getPlaca());
        if (carroExistente.isPresent()) {
            throw new IllegalArgumentException("Já existe um carro com essa placa cadastrado.");
        }

        return carroRepository.save(carro);
    }


    public CarroEntity buscarCarro(Integer id) {
        return carroRepository.findById(Long.valueOf(id)).orElseThrow(() -> new RuntimeException("Carro não encontrado!"));
    }

    public void atualizarCarro(Integer idCarro, String placaCarro) {
        CarroEntity carro = carroRepository.findById(Long.valueOf(idCarro)).orElseThrow(() -> new RuntimeException("Carro não encontrado!"));

        carro.setPlaca(placaCarro);
        carroRepository.save(carro);
    }

    public List<CarroEntity> listarCarros() {
        return carroRepository.findAll();
    }
}
