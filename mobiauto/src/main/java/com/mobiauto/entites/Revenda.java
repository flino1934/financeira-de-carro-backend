package com.mobiauto.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_revenda")
public class Revenda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Campo obrigatório")
    @NotEmpty(message = "Campo obrigatório")
    @CNPJ(message = "Informar CNPJ valído")
    @Column(unique = true)
    private String cnpj;


    @NotNull(message = "Campo obrigatório")
    @NotEmpty(message = "Campo obrigatório")
    private String nomeSocial;

}
