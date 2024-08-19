package com.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

}
