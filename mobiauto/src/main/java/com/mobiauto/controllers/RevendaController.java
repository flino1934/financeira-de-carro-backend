package com.mobiauto.controllers;

import com.mobiauto.dto.RevendaDTO;
import com.mobiauto.services.RevendaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/revendas")
public class RevendaController {

    @Autowired
    private RevendaServiceInterface service;

    @GetMapping
    public ResponseEntity<Page<RevendaDTO>> findAll(Pageable pageable) {
        Page<RevendaDTO> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RevendaDTO> findById(@PathVariable long id) {

        RevendaDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);

    }

    @PostMapping
    public ResponseEntity<RevendaDTO> insert(@Valid @RequestBody RevendaDTO dto){


        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);

    }

}
