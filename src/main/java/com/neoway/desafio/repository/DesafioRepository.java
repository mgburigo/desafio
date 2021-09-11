package com.neoway.desafio.repository;

import com.neoway.desafio.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface DesafioRepository extends JpaRepository<Cliente, Long> {
}
