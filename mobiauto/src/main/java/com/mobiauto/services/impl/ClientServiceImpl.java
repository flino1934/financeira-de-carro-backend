package com.mobiauto.services.impl;

import com.mobiauto.dto.ClienteDTO;
import com.mobiauto.entites.Cliente;
import com.mobiauto.repositories.ClienteRepository;
import com.mobiauto.services.ClienteServiceInterface;
import com.mobiauto.services.exceptions.ResourceNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClienteServiceInterface {

    @Autowired
    private ClienteRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<ClienteDTO> findAllPaged(Pageable pageable) {

        Page<Cliente> list = repository.findAll(pageable);

        return list.map(x -> new ClienteDTO(x));
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteDTO findById(long id) {


        Optional<Cliente> obj = repository.findById(id);
        Cliente entity = obj.orElseThrow(() -> new ResourceNotFoundExceptions("Cliente não encontrado"));

        return new ClienteDTO(entity);
    }

    @Override
    public ClienteDTO insert(ClienteDTO clienteDTO) {

        Cliente entity = new Cliente();
        entity.setNome(clienteDTO.getNome());
        entity.setEmail(clienteDTO.getEmail());
        entity.setTelefone(clienteDTO.getTelefone());

        repository.save(entity);

        return new ClienteDTO(entity);
    }
}
