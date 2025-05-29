package projetoMecanica.mecanica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoMecanica.mecanica.entidades.ClienteEntity;
import projetoMecanica.mecanica.services.ServiceCliente;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteControl {

    @Autowired
    private ServiceCliente serviceCliente;

    @GetMapping("/listarclientes")
    public List<ClienteEntity> listarClientes() {
        return serviceCliente.listarClientes();
    }

    @PostMapping("/addcliente")
    public ResponseEntity<ClienteEntity> adicionarCliente(@RequestBody ClienteEntity cliente) {
        ClienteEntity novoCliente = serviceCliente.adicionarCliente(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/telefone")
    public ResponseEntity<ClienteEntity> atualizarTelefoneCliente(
            @PathVariable Integer id,
            @RequestParam String novoTelefone) {

        ClienteEntity atualizado = serviceCliente.atualizarTelefoneCliente(id, novoTelefone);
        return ResponseEntity.ok(atualizado);
    }


}
