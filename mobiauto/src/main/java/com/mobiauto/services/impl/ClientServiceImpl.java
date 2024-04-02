package com.mobiauto.services.impl;

import com.mobiauto.dto.ClienteDTO;
import com.mobiauto.entites.Cliente;
import com.mobiauto.repositories.ClienteRepository;
import com.mobiauto.services.ClienteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClienteServiceInterface {

    @Autowired
    private ClienteRepository repository;
    @Override
    public Page<ClienteDTO> findAllPaged(Pageable pageable) {

        Page<Cliente> list = repository.findAll(pageable);

        return list.map(x -> new ClienteDTO(x));
    }

    @Override
    public ClienteDTO findById(long id) {
        return null;
    }

    @Override
    public ClienteDTO insert(ClienteDTO ClienteDTO) {
        return null;
    }
}
