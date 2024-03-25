package com.mobiauto.services;


import com.mobiauto.dto.RevendaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RevendaServiceInterface {

    Page<RevendaDTO> findAllPaged(Pageable pageable);

    RevendaDTO findById(long id);

    RevendaDTO insert(RevendaDTO revendaDTO);
}

