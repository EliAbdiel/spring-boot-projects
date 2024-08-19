package com.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.model.Cliente;
import com.market.repository.ClientesRepository;

@Service
public class ClientesServiceImpl implements ClientesService {

	private ClientesRepository clientesRepository;

	@Autowired
	public ClientesServiceImpl(ClientesRepository clientesRepository) {
		this.clientesRepository = clientesRepository;
	}

	@Override
	public Cliente autenticarCliente(String usuario, String password) {
		return clientesRepository.findByUsuarioAndPassword(usuario, password);
	}

	@Override
	public boolean registrarCliente(Cliente cliente) {
		if(clientesRepository.findById(cliente.getUsuario()).isPresent()) {
			return false;
		}
		clientesRepository.save(cliente);
		return true;
	}

}
