package com.mobiauto.services.impl;

import com.mobiauto.dto.VeiculoDto;
import com.mobiauto.entites.Veiculo;
import com.mobiauto.repositories.VeiculoRepository;
import com.mobiauto.services.VeiculoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VeiculoServiceImpl implements VeiculoServiceInterface {

    @Autowired
    private VeiculoRepository repository;

    @Override
    public Page<VeiculoDto> findAllPaged(Pageable pageable) {

        Page<Veiculo> list = repository.findAll(pageable);
        return list.map(x -> new VeiculoDto(x));

    }

    @Override
    public VeiculoDto findById(long id) {
        return null;
    }

    @Override
    public VeiculoDto insert(VeiculoDto VeiculoDTO) {
        return null;
    }
}
