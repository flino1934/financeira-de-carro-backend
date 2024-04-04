package com.mobiauto.services.impl;

import com.mobiauto.dto.OportunidadesDTO;
import com.mobiauto.entites.Cliente;
import com.mobiauto.entites.Oportunidades;
import com.mobiauto.entites.Veiculo;
import com.mobiauto.repositories.ClienteRepository;
import com.mobiauto.repositories.OportunidadeRepository;
import com.mobiauto.repositories.VeiculoRepository;
import com.mobiauto.services.OportunidadeServiceInterface;
import com.mobiauto.services.exceptions.ResourceNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OportunidadesServiceImpl implements OportunidadeServiceInterface {

    @Autowired
    private OportunidadeRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;


    @Transactional(readOnly = true)
    @Override
    public Page<OportunidadesDTO> findAllPaged(Pageable pageable) {

        Page<Oportunidades> list = repository.findAll(pageable);
        return list.map(x -> new OportunidadesDTO(x));

    }
    @Transactional(readOnly = true)
    @Override
    public OportunidadesDTO findById(long id) {

        Optional<Oportunidades> obj = repository.findById(id);
        Oportunidades entity = obj.orElseThrow(() -> new ResourceNotFoundExceptions("Oportunidade não encontrada"));

        return new OportunidadesDTO(entity);
    }
    @Transactional
    @Override
    public OportunidadesDTO insert(OportunidadesDTO dto) {

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                        .orElseThrow(()-> new ResourceNotFoundExceptions("Cliente não encontrado"));

        Veiculo veiculo = veiculoRepository.findById(dto.getVeiculoId())
                .orElseThrow(()-> new ResourceNotFoundExceptions("Veiculo não encontrado"));

        Oportunidades oportunidades = new Oportunidades();
        oportunidades.setMotivoConclusao(dto.getMotivoConclusao());
        oportunidades.setCliente(cliente);
        oportunidades.setVeiculo(veiculo);
        oportunidades.setStatus(dto.getStatus());
        oportunidades.setDataConclusao(dto.getDataConclusao());
        oportunidades.setDataAtribuicao(dto.getDataAtribuicao());

        return new OportunidadesDTO(repository.save(oportunidades));
    }
}
