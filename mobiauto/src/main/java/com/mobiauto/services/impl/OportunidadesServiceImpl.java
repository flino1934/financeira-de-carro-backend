package com.mobiauto.services.impl;

import com.mobiauto.dto.ClienteDTO;
import com.mobiauto.dto.OportunidadesDTO;
import com.mobiauto.dto.RevendaDTO;
import com.mobiauto.entites.Oportunidades;
import com.mobiauto.entites.Revenda;
import com.mobiauto.repositories.OportunidadeRepository;
import com.mobiauto.services.OportunidadeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OportunidadesServiceImpl implements OportunidadeServiceInterface {

    @Autowired
    private OportunidadeRepository repository;

    @Override
    public Page<OportunidadesDTO> findAllPaged(Pageable pageable) {

        Page<Oportunidades> list = repository.findAll(pageable);
        return list.map(x -> new OportunidadesDTO(x));

    }

    @Override
    public OportunidadesDTO findById(long id) {
        return null;
    }

    @Override
    public OportunidadesDTO insert(ClienteDTO ClienteDTO) {
        return null;
    }
}
