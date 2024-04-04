package com.mobiauto.services.validations;

import com.mobiauto.controllers.exceptions.FieldMessage;
import com.mobiauto.dto.UsuarioInsertDto;
import com.mobiauto.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UsuarioInsertDto> {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void initialize(UserInsertValid ann) {
    }

    @Override
    public boolean isValid(UsuarioInsertDto dto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        if (repository.existsByEmail(dto.getEmail())) {
        list.add(new FieldMessage("email","E-mail já existe na nossa base de dados"));
        }
        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
