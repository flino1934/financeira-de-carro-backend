package com.mobiauto.services.impl;

import com.mobiauto.dto.UsuarioDTO;
import com.mobiauto.dto.UsuarioInsertDto;
import com.mobiauto.entites.Usuario;
import com.mobiauto.entites.enums.Cargo;
import com.mobiauto.repositories.UsuarioRepository;
import com.mobiauto.services.UsuarioServiceInterface;
import com.mobiauto.services.exceptions.DuplicatefieldException;
import com.mobiauto.services.exceptions.FormatInvalidException;
import com.mobiauto.services.exceptions.ResourceNotFoundExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioServiceInterface, UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public Page<UsuarioDTO> findAllPaged(Pageable pageable) {
        Page<Usuario> list = repository.findAll(pageable);
        return list.map(x -> new UsuarioDTO(x));
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioDTO findById(long id) {

        Optional<Usuario> obj = repository.findById(id);
        Usuario entity = obj.orElseThrow(()-> new ResourceNotFoundExceptions("Usuario "+id+"não encontrado "));

        return new UsuarioDTO(entity);
    }

    @Override
    public UsuarioDTO insert(UsuarioInsertDto usuarioDTO) {

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));

        Set<Cargo> cargos = new HashSet<>();
        usuarioDTO.getCargo().forEach(cargoDescricao -> {
            Cargo cargo = Cargo.fromDescricao(cargoDescricao);
            cargos.add(cargo);
        });
        usuario.setCargo(cargos);

        return new UsuarioDTO(repository.save(usuario));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Usuario usuario = repository.findByEmail(s);

        if (usuario == null){
           logger.error("Usuario não encontado "+s);
            throw new UsernameNotFoundException("Email não encontrado!");
        }

        logger.info("Usuario logado: "+s);

        return usuario;

    }
}
