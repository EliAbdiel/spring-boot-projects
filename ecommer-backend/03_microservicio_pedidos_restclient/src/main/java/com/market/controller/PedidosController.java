package com.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.model.ElementosPedido;
import com.market.model.Pedido;
import com.market.service.PedidosService;
@CrossOrigin("*")
@RestController
public class PedidosController {

	private PedidosService pedidosService;
	@Autowired
	public PedidosController(PedidosService pedidosService) {
		this.pedidosService = pedidosService;
	}

	@GetMapping(value="pedidos",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pedido>> pedidosUsuario(@RequestParam("usuario") String usuario){
		return new ResponseEntity<>(pedidosService.pedidosUsuario(usuario), HttpStatus.OK);
	}
	
	@PostMapping(value="pedido",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> guardarPedido(@RequestBody List<ElementosPedido> elementosPedido,
												@RequestParam("usuario") String usuario){
		Pedido pedido=pedidosService.guardarPedido(elementosPedido, usuario);
		if(pedido!=null) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
}
