package com.market.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.market.model.ElementosPedido;
import com.market.model.Pedido;
import com.market.repository.ElementosPedidosRepository;
import com.market.repository.PedidosRepository;
@Service
public class PedidosServiceImpl implements PedidosService {
	private String urlProductos="http://localhost:8082/";
	@Autowired
	private RestClient restClient;
	@Autowired
	private PedidosRepository pedidosRepository;
	@Autowired
	private ElementosPedidosRepository elementosPedidosRepository;

	@Override
	public List<Pedido> pedidosUsuario(String usuario) {
		return pedidosRepository.findByUsuario(usuario);
	}

	@Override
	public Pedido guardarPedido(List<ElementosPedido> elementosPedido, String usuario) {
		try {
			//creamos objeto Pedido y lo guardamos
			Pedido pedido=new Pedido(0,usuario,new Date(),"pendiente",null);
			Pedido p=pedidosRepository.save(pedido);
			//guardamos los objetos ElementosPedido
			elementosPedido.forEach(e->{
				e.setIdPedidoFk(p.getIdPedido());
				elementosPedidosRepository.save(e);
				//además de guardar el elementosPedido, actualiza el stock
				//del producto correspondiente llamando al recurso
				//del microservicio de productos
				UriComponentsBuilder builder=UriComponentsBuilder.fromHttpUrl(urlProductos+"producto")
				.queryParam("idProducto", e.getProducto().getIdProducto())
				.queryParam("unidades", e.getUnidades());
				restClient.put()
				.uri(builder.toUriString())
				.retrieve();
				//restTemplate.put(builder.toUriString(),null);
			});
			return pedido;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
