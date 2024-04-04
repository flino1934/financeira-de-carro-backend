package com.mobiauto.dto;

import com.mobiauto.entites.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    @NotBlank(message = "Campo obrigatório")
    private String marca;
    @NotBlank(message = "Campo obrigatório")
    private String modelo;
    @NotBlank(message = "Campo obrigatório")
    private String versao;
    @NotNull
    private Integer anoModelo;

    public VeiculoDto(Veiculo entity) {
        this.id = entity.getId();
        this.marca = entity.getMarca();
        this.modelo = entity.getModelo();
        this.versao = entity.getVersao();
        this.anoModelo = entity.getAnoModelo();
    }
}
