package projetoMecanica.mecanica.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projetoMecanica.mecanica.entidades.CarroEntity;
import projetoMecanica.mecanica.services.ServiceCarro;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroControl {

    @Autowired
    private ServiceCarro serviceCarro;

    @PostMapping("/adicionarcarro")
    public CarroEntity adicionarCarro(@RequestBody CarroEntity carro) {
        return serviceCarro.adicionarCarro(carro);
    }

    @GetMapping("/listarcarros")
    public List<CarroEntity> listarCarros() {
        return serviceCarro.listarCarros();
    }
}

