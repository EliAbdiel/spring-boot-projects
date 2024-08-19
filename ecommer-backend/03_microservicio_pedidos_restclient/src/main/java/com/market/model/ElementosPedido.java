package com.market.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ElementosPedido")
@Table(name="elementosPedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElementosPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idElementosPedido;
	private int idPedidoFk;
	@ManyToOne()
	@JoinColumn(name="idProductoFk", referencedColumnName = "idProducto")
	private Producto producto;
	private int unidades;
	
}
