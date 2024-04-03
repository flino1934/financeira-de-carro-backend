package com.mobiauto.controllers;

import com.mobiauto.dto.ClienteDTO;
import com.mobiauto.dto.RevendaDTO;
import com.mobiauto.services.ClienteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/clientes")
public class ClientController {

    @Autowired
    private ClienteServiceInterface service;

    @GetMapping
    public ResponseEntity<Page<ClienteDTO>> findAll(Pageable pageable) {
        Page<ClienteDTO> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable long id) {

        ClienteDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);

    }

    @PostMapping
    public ResponseEntity<ClienteDTO> insert(@Valid @RequestBody ClienteDTO dto) {


        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);

    }
}
