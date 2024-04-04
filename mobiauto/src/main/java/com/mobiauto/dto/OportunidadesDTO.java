package com.mobiauto.dto;

import com.mobiauto.entites.Cliente;
import com.mobiauto.entites.Oportunidades;
import com.mobiauto.entites.Veiculo;
import com.mobiauto.entites.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OportunidadesDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String motivoConclusao;
    private Instant dataAtribuicao;
    private Instant dataConclusao;
    private Status status;

    private Long clienteId;
    private Long veiculoId;

    public OportunidadesDTO(Oportunidades entity) {
        this.id = entity.getId();
        this.motivoConclusao = entity.getMotivoConclusao();
        this.dataAtribuicao = entity.getDataAtribuicao();
        this.dataConclusao = entity.getDataConclusao();
        this.status = entity.getStatus();
        this.clienteId = entity.getCliente() != null ? entity.getCliente().getId() : null;
        this.veiculoId = entity.getVeiculo() != null ? entity.getVeiculo().getId() : null;
    }
}
