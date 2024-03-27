package com.mobiauto.services;


import com.mobiauto.dto.VeiculoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface VeiculoServiceInterface {

    Page<VeiculoDto> findAllPaged(Pageable pageable);

    VeiculoDto findById(long id);

    VeiculoDto insert(VeiculoDto VeiculoDTO);
}

