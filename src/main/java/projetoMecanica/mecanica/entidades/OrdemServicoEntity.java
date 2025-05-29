package projetoMecanica.mecanica.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ordem_servico")
public class OrdemServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ordem")
    private Long id;

    @Column(name = "data_abertura_ordem", nullable = false, updatable = false)
    private LocalDate dataAbertura;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_servico", nullable = false)
    private ServicosEntity servico;

    @Column(name = "status_ordem", length = 50)
    private String statusOrdem;

    @Column(name = "preco_ordem")
    private Double valorOrdem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carro")
    private CarroEntity carro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    @JsonIgnoreProperties({"id", "telefone", "carros", "outraPropriedadeQueNaoQuerMostrar"})
    private ClienteEntity cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mecanica")
    @JsonBackReference
    private MecanicaEntity mecanica;

    @PrePersist
    protected void onCreate() {
        if (this.dataAbertura == null) {
            this.dataAbertura = LocalDate.now();
        }
        calcularValorTotal();
    }

    @PreUpdate
    public void onUpdate() {
        calcularValorTotal();
    }

    public void calcularValorTotal() {
        double total = 0.0;

        if (Objects.nonNull(servico) && servico.getPrecoServico() != null) {
            total += servico.getPrecoServico();
        }

        this.valorOrdem = total;
    }
}
