package com.mobiauto.dto;

import com.mobiauto.entites.Cliente;
import com.mobiauto.services.validations.ClienteValid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ClienteValid
public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    @NotBlank(message = "Campo obrigatório")
    private String nome;
    @Email(message = "Informar email valido")
    private String email;
    @NotBlank(message = "Campo obrigatório")
    private String telefone;

    public ClienteDTO(Cliente entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
        this.telefone = entity.getTelefone();
    }
}
