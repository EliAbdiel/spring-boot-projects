package com.market.service;

import java.util.List;

import com.market.model.Categoria;
import com.market.model.Producto;

public interface ProductosService {
	List<Categoria> categorias();
	List<Producto> productosPorCategoria(int idCategoria);
	Producto actualizarStock(int idProducto, int unidades);
	Producto productoPorCodigo(int idProducto);
}
