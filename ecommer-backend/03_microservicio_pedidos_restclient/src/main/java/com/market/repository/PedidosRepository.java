package com.market.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.model.Pedido;

public interface PedidosRepository extends JpaRepository<Pedido, Integer> {
	List<Pedido> findByUsuario(String usuario);
}
