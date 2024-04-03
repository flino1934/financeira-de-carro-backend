package com.mobiauto.repositories;

import com.mobiauto.entites.Cliente;
import com.mobiauto.entites.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByEmail(String email);

}
