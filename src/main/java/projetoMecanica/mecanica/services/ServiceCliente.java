package projetoMecanica.mecanica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoMecanica.mecanica.entidades.ClienteEntity;
import projetoMecanica.mecanica.repository.ClienteRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceCliente {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity adicionarCliente(ClienteEntity cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("A entidade Cliente não pode ser nula.");
        }

        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente não pode ser nulo ou vazio.");
        }

        if (cliente.getTelefone() == null || cliente.getTelefone().isEmpty()) {
            throw new IllegalArgumentException("O telefone do cliente não pode ser nulo ou vazio.");
        }

        return clienteRepository.save(cliente);
    }

    public ClienteEntity atualizarTelefoneCliente(Integer id, String novoTelefone) {
        ClienteEntity cliente = clienteRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));

        cliente.setTelefone(novoTelefone);
        return clienteRepository.save(cliente);
    }

    public ClienteEntity buscarCliente(Integer id) {
        return clienteRepository.findById(Long.valueOf(id)).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
    }

    public List<ClienteEntity> listarClientes() {
        return clienteRepository.findAll();
    }
}
