package com.mobiauto.dto;

import com.mobiauto.entites.Revenda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevendaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String cnpj;
    private String nomeSocial;

    public RevendaDTO(Revenda entity) {
        this.id = entity.getId();
        this.cnpj = entity.getCnpj();
        this.nomeSocial = entity.getNomeSocial();
    }

}
