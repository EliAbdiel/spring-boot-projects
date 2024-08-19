package com.market.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.model.Producto;

public interface ProductosRepository extends JpaRepository<Producto, Integer> {
	List<Producto> findByIdCategoria(int idCategoria);
}
