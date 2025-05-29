package projetoMecanica.mecanica.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projetoMecanica.mecanica.entidades.ServicosEntity;
import projetoMecanica.mecanica.services.ServiceServicos;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicosControl {

    @Autowired
    private ServiceServicos serviceServicos;

    @PostMapping("/adicionarServico")
    public ServicosEntity adicionarServico(@RequestBody ServicosEntity servicos) {
        return serviceServicos.adicionarServico(servicos);
    }

    @GetMapping("/listarservicos")
    public List<ServicosEntity> listarServicos() {
        return serviceServicos.listarServicos();
    }
}
