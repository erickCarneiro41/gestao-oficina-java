package projetoMecanica.mecanica.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CarroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carro")
    private Long id;

    @Column(name = "marca_carro")
    private String marca;

    @Column(name = "modelo_carro")
    private String modelo;

    @Column(name = "placa_carro")
    private String placa;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonBackReference
    private ClienteEntity cliente;

    @Transient
    public Long getIdCliente() {
        return cliente != null ? cliente.getId() : null;
    }
}
