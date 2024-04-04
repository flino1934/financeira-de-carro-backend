package com.mobiauto.repositories;

import com.mobiauto.entites.Oportunidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OportunidadeRepository extends JpaRepository<Oportunidades, Long> {

}
