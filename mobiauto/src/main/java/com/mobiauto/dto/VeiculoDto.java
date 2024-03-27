package com.mobiauto.dto;

import com.mobiauto.entites.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Campo obrigatório")
    private String marca;
    @NotBlank(message = "Campo obrigatório")
    private String modelo;
    @NotBlank(message = "Campo obrigatório")
    private String versao;
    @NotBlank(message = "Campo obrigatório")
    private Integer anoModelo;

    public VeiculoDto(Veiculo entity) {
        this.marca = entity.getMarca();
        this.modelo = entity.getModelo();
        this.versao = entity.getVersao();
        this.anoModelo = entity.getAnoModelo();
    }
}
