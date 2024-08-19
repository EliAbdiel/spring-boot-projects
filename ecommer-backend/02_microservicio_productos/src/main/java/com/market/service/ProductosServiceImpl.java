package com.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.model.Categoria;
import com.market.model.Producto;
import com.market.repository.CategoriasRepository;
import com.market.repository.ProductosRepository;
@Service
public class ProductosServiceImpl implements ProductosService {

	private CategoriasRepository categoriasRepository;
	private ProductosRepository productosRepository;

	@Autowired
	public ProductosServiceImpl(CategoriasRepository categoriasRepository,
								ProductosRepository productosRepository) {
		this.categoriasRepository = categoriasRepository;
		this.productosRepository = productosRepository;
	}

	@Override
	public List<Categoria> categorias() {
		return categoriasRepository.findAll();
	}

	@Override
	public List<Producto> productosPorCategoria(int idCategoria) {
		return productosRepository.findByIdCategoria(idCategoria);
	}

	@Override
	public Producto actualizarStock(int idProducto, int unidades) {
		Producto producto=productoPorCodigo(idProducto);
		if(producto!=null&producto.getStock()>=unidades) {
			producto.setStock(producto.getStock()-unidades);
			productosRepository.save(producto);
			return producto;
		}
		return null;
	}

	@Override
	public Producto productoPorCodigo(int idProducto) {
		return productosRepository.findById(idProducto).orElse(null);
	}

}
