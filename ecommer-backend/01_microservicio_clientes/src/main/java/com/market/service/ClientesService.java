package com.market.service;

import com.market.model.Cliente;


public interface ClientesService {
	Cliente autenticarCliente(String usuario, String password);
	boolean registrarCliente(Cliente cliente);
}
