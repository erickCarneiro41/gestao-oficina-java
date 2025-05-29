package projetoMecanica.mecanica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoMecanica.mecanica.entidades.MecanicaEntity;
import projetoMecanica.mecanica.repository.MecanicaRepository;

import java.util.List;


@Service
public class ServiceMecanica {

    @Autowired
    private MecanicaRepository mecanicaRepository;

    public MecanicaEntity adicionarMecanica(MecanicaEntity mecanica) {
        return mecanicaRepository.save(mecanica);
    }

    public 

    public List<MecanicaEntity> ListarMecanica() {
        return mecanicaRepository.findAll();
    }

}
