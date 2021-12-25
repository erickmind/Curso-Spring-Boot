package br.com.digisystem.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digisystem.api.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
}
