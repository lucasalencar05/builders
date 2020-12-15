package com.builders.repositories;

import com.builders.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

     List<Cliente> findByNomeIgnoreCaseContaining(String nome);

     Cliente findByCpf(String cpf);

}
