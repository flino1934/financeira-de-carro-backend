package com.mobiauto.controllers;

import com.mobiauto.dto.ClienteDTO;
import com.mobiauto.services.ClienteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
