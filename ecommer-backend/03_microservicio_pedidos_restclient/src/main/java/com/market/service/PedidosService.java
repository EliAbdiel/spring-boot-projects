package com.market.service;

import java.util.List;

import com.market.model.ElementosPedido;
import com.market.model.Pedido;

public interface PedidosService {
	List<Pedido> pedidosUsuario(String usuario);
	Pedido guardarPedido(List<ElementosPedido> elementosPedido, String usuario);
}
