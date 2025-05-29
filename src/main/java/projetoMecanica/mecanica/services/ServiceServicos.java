package projetoMecanica.mecanica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoMecanica.mecanica.entidades.ServicosEntity;
import projetoMecanica.mecanica.repository.ServicosRepository;

import java.util.List;

@Service
public class ServiceServicos {

    @Autowired
    private ServicosRepository servicosRepository;

    public ServicosEntity adicionarServico(ServicosEntity servicos) {
       return servicosRepository.save(servicos);
    }

    public ServicosEntity buscarServico(Integer idServico) {
        return servicosRepository.findById(Long.valueOf(idServico)).orElse(null);
    }

    public List<ServicosEntity> listarServicos() {
        return servicosRepository.findAll();
    }

    public ServicosEntity modificarPreco(Integer idServico, Double novoPreco) {
        ServicosEntity servico = servicosRepository.findById(Long.valueOf(idServico)).orElseThrow(() -> new RuntimeException("Servico não encontrado pelo ID" + idServico));
        servico.setPrecoServico(novoPreco);
        return servicosRepository.save(servico);
    }
}
