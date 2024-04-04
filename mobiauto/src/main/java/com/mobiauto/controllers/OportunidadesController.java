package com.mobiauto.controllers;

import com.mobiauto.dto.ClienteDTO;
import com.mobiauto.dto.OportunidadesDTO;
import com.mobiauto.services.OportunidadeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
