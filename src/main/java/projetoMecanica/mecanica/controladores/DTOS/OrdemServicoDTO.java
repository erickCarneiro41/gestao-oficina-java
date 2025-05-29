package projetoMecanica.mecanica.controladores.DTOS;

public class OrdemServicoDTO {

    private Long idCliente;
    private Long idCarro;
    private Long idMecanica;
    private Long idServicoPrincipal;
    private String statusOrdem;

    public Long getIdServicoPrincipal() {
        return idServicoPrincipal;
    }

    public void setIdServicoPrincipal(Long idServicoPrincipal) {
        this.idServicoPrincipal = idServicoPrincipal;
    }

    public Long getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Long idCarro) {
        this.idCarro = idCarro;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdMecanica() {
        return idMecanica;
    }

    public void setIdMecanica(Long idMecanica) {
        this.idMecanica = idMecanica;
    }

    public String getStatusOrdem() {
        return statusOrdem;
    }

    public void setStatusOrdem(String statusOrdem) {
        this.statusOrdem = statusOrdem;
    }
}

