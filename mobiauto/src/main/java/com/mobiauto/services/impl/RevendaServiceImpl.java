package com.mobiauto.services.impl;

import com.mobiauto.dto.RevendaDTO;
import com.mobiauto.entites.Revenda;
import com.mobiauto.repositories.RevendaRepository;
import com.mobiauto.services.RevendaServiceInterface;
import com.mobiauto.services.exceptions.DuplicatefieldException;
import com.mobiauto.services.exceptions.FormatInvalidException;
import com.mobiauto.services.exceptions.ResourceNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RevendaServiceImpl implements RevendaServiceInterface {

    @Autowired
    private RevendaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<RevendaDTO> findAllPaged(Pageable pageable){

        Page<Revenda> list = repository.findAll(pageable);
        return list.map(x -> new RevendaDTO(x));
    }

    @Transactional(readOnly = true)
    @Override
    public RevendaDTO findById(long id) {

        Optional<Revenda> obj = repository.findById(id);
        Revenda entity = obj.orElseThrow(()-> new ResourceNotFoundExceptions("Revenda "+id+"não encontrado "));

        return new RevendaDTO(entity);
    }

    @Transactional
    @Override
    public RevendaDTO insert(RevendaDTO revendaDTO) {

        String cnpj = revendaDTO.getCnpj();
        validateCnpj(cnpj);

        Revenda revenda = new Revenda();
        revenda.setCnpj(cnpj);
        revenda.setNomeSocial(revendaDTO.getNomeSocial());
        return new RevendaDTO(repository.save(revenda));
    }

    private void validateCnpj(String cnpj){

        if (repository.existsByCnpj(cnpj)) {
            throw new DuplicatefieldException("O CNPJ já está cadastrado: " + cnpj);
        }
        if (!(cnpj.length() == 14 && cnpj.matches("\\d+"))) {
            throw new FormatInvalidException("número do registro de contribuinte corporativo brasileiro (CNPJ) inválido: " + cnpj);
        }

    }


}
