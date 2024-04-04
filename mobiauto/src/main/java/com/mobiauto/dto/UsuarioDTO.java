package com.mobiauto.dto;

import com.mobiauto.entites.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String nome;

    @Email(message = "Informar email valido")
    private String email;

    private Long revendaId;

    private Set<String> cargo = new HashSet();

    public UsuarioDTO(Usuario entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
        this.revendaId = entity.getRevenda() != null ? entity.getRevenda().getId() : null; // Define o ID da revenda se ela não for nula
        entity.getCargo().forEach(cargo -> this.cargo.add(cargo.getDescricao()));
    }
}
