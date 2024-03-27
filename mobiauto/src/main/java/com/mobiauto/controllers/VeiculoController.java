package com.mobiauto.controllers;

import com.mobiauto.dto.RevendaDTO;
import com.mobiauto.dto.VeiculoDto;
import com.mobiauto.services.VeiculoServiceInterface;
import com.mobiauto.services.impl.VeiculoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
