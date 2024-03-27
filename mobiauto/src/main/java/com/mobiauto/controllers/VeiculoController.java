package com.mobiauto.controllers;

import com.mobiauto.dto.RevendaDTO;
import com.mobiauto.dto.UsuarioDTO;
import com.mobiauto.dto.UsuarioInsertDto;
import com.mobiauto.dto.VeiculoDto;
import com.mobiauto.services.VeiculoServiceInterface;
import com.mobiauto.services.impl.VeiculoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoServiceInterface service;

    @GetMapping
    public ResponseEntity<Page<VeiculoDto>> findAll(Pageable pageable) {
        Page<VeiculoDto> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VeiculoDto> findById(@PathVariable long id) {

        VeiculoDto dto = service.findById(id);
        return ResponseEntity.ok().body(dto);

    }

    @PostMapping
    public ResponseEntity<VeiculoDto> insert(@Valid @RequestBody VeiculoDto dto){


        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);

    }
}
