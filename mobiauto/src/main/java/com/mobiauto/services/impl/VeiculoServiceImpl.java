package com.mobiauto.services.impl;

import com.mobiauto.dto.VeiculoDto;
import com.mobiauto.entites.Veiculo;
import com.mobiauto.repositories.VeiculoRepository;
import com.mobiauto.services.VeiculoServiceInterface;
import com.mobiauto.services.exceptions.ResourceNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

        Optional<Veiculo> obj = repository.findById(id);
        Veiculo entity = obj.orElseThrow(()-> new ResourceNotFoundExceptions("Veiculo "+id+"não encontrado "));

        return new VeiculoDto(entity);
    }

    @Override
    public VeiculoDto insert(VeiculoDto dto) {

        Veiculo veiculo = new Veiculo();
        veiculo.setAnoModelo(dto.getAnoModelo());
        veiculo.setVersao(dto.getVersao());
        veiculo.setModelo(dto.getModelo());
        veiculo.setMarca(dto.getMarca());

        return new VeiculoDto(repository.save(veiculo));
    }
}
