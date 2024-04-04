package com.mobiauto.controllers;

import com.mobiauto.dto.OportunidadesDTO;
import com.mobiauto.services.OportunidadeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RequestMapping(value = "/oportunidades")
@RestController
public class OportunidadesController {

    @Autowired
    private OportunidadeServiceInterface service;

    @GetMapping
    public ResponseEntity<Page<OportunidadesDTO>> findAll(Pageable pageable) {
        Page<OportunidadesDTO> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OportunidadesDTO> findById(@PathVariable long id) {

        OportunidadesDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);

    }

    @PostMapping
    public ResponseEntity<OportunidadesDTO> insert(@Valid @RequestBody OportunidadesDTO dto) {


        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);

    }


}
