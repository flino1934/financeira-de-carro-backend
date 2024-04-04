package com.mobiauto.services;


import com.mobiauto.dto.ClienteDTO;
import com.mobiauto.dto.OportunidadesDTO;
import com.mobiauto.entites.Oportunidades;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface OportunidadeServiceInterface {

    Page<OportunidadesDTO> findAllPaged(Pageable pageable);

    OportunidadesDTO findById(long id);

    OportunidadesDTO insert(ClienteDTO ClienteDTO);
}

