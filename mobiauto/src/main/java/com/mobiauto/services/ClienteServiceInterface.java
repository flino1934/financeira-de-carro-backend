package com.mobiauto.services;


import com.mobiauto.dto.ClienteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ClienteServiceInterface {

    Page<ClienteDTO> findAllPaged(Pageable pageable);

    ClienteDTO findById(long id);

    ClienteDTO insert(ClienteDTO ClienteDTO);
}

