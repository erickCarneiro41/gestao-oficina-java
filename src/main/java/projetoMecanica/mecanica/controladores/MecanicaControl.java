package projetoMecanica.mecanica.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projetoMecanica.mecanica.entidades.MecanicaEntity;
import projetoMecanica.mecanica.services.ServiceMecanica;

import java.util.List;

@RestController
@RequestMapping("/mecanica")
public class MecanicaControl {

    @Autowired
    private ServiceMecanica serviceMecanica;

    @PostMapping("/addMecanica")
    public MecanicaEntity adicionarMecanica(@RequestBody MecanicaEntity mecanica) {
        return serviceMecanica.adicionarMecanica(mecanica);
    }

    @GetMapping("/listarmecanica")
    public List<MecanicaEntity> listarMecanica() {
        return serviceMecanica.ListarMecanica();
    }
}
