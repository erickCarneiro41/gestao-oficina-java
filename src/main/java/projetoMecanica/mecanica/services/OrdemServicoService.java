package projetoMecanica.mecanica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoMecanica.mecanica.controladores.DTOS.OrdemServicoDTO;
import projetoMecanica.mecanica.entidades.*;
import projetoMecanica.mecanica.repository.*;


@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private MecanicaRepository mecanicaRepository;

    @Autowired
    private ServicosRepository servicoRepository;

    public OrdemServicoEntity salvarOrdem(OrdemServicoDTO dto) {
        OrdemServicoEntity ordem = new OrdemServicoEntity();

        // Validar e setar cliente
        ClienteEntity cliente = clienteRepository.findById(dto.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Id cliente não pode ser nulo ou inexistente!"));
        ordem.setCliente(cliente);

        // Validar e setar carro
        CarroEntity carro = carroRepository.findById(dto.getIdCarro())
                .orElseThrow(() -> new RuntimeException("Id carro não pode ser nulo ou inexistente!"));
        ordem.setCarro(carro);

        // Validar e setar serviço principal
        ServicosEntity servicoPrincipal = servicoRepository.findById(dto.getIdServicoPrincipal())
                .orElseThrow(() -> new RuntimeException("Id serviço principal não pode ser nulo ou inexistente!"));
        ordem.setServico(servicoPrincipal);

        // Validar e setar mecânica
        MecanicaEntity mecanica = mecanicaRepository.findById(dto.getIdMecanica())
                .orElseThrow(() -> new RuntimeException("Id mecânica não pode ser nulo ou inexistente!"));
        ordem.setMecanica(mecanica);

        // Setar status
        ordem.setStatusOrdem(dto.getStatusOrdem());

        return ordemServicoRepository.save(ordem);
    }
}
