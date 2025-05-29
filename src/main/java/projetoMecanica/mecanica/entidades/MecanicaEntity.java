package projetoMecanica.mecanica.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;


import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MecanicaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mecanica")
    private Long id;

    private String nomeMecanica;

    private String enderecoMecanica;

    @OneToMany(mappedBy = "mecanica")
    @JsonManagedReference
    private List<OrdemServicoEntity> ordemServico;

}
