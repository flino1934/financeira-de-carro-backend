package com.mobiauto.services.validations;

import com.mobiauto.controllers.exceptions.FieldMessage;
import com.mobiauto.dto.ClienteDTO;
import com.mobiauto.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;


public class ClientesValidator implements ConstraintValidator<ClienteValid, ClienteDTO> {

    @Autowired
    private ClienteRepository repository;

    @Override
    public void initialize(ClienteValid ann) {
    }

    @Override
    public boolean isValid(ClienteDTO dto, ConstraintValidatorContext context) {

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
