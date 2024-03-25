package com.mobiauto.dto;

import com.mobiauto.services.validations.UserInsertValid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@UserInsertValid
public class UsuarioInsertDto extends UsuarioDTO{

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Campo obrigatório")
    @Size(min = 6,max = 20, message = "A senha deve ter de 6 a 20 caracteres")
    private String senha;

}
