package projetoMecanica.mecanica.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoMecanica.mecanica.controladores.DTOS.OrdemServicoDTO;
import projetoMecanica.mecanica.entidades.OrdemServicoEntity;
import projetoMecanica.mecanica.services.OrdemServicoService;

@RestController
@RequestMapping("/ordemServico")
public class OrdemServicoControl {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @PostMapping("/adicionar")
    public ResponseEntity<OrdemServicoEntity> adicionarOrdem(@RequestBody OrdemServicoDTO dto) {
        OrdemServicoEntity ordemSalva = ordemServicoService.salvarOrdem(dto);
        return ResponseEntity.ok(ordemSalva);
    }

    @PutMapping
    public ResponseEntity<OrdemServicoEntity> darBaixa() {

    }
}
