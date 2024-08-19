package com.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.model.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, String> {
	Cliente findByUsuarioAndPassword(String usuario, String password);
}
