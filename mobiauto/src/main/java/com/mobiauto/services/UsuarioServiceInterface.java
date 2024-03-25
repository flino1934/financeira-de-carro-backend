package com.mobiauto.services;


import com.mobiauto.dto.UsuarioDTO;
import com.mobiauto.dto.UsuarioInsertDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioServiceInterface {

    Page<UsuarioDTO> findAllPaged(Pageable pageable);

    UsuarioDTO findById(long id);

    UsuarioDTO insert(UsuarioInsertDto UsuarioDTO);
}

