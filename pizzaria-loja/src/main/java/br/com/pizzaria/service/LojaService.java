package br.com.pizzaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.pizzaria.dao.PedidoDAO;
import br.com.pizzaria.model.Pedido;

@Controller
public class LojaService {

	@Autowired private PedidoDAO pedidoDAO;
	
	@RequestMapping(	value = "/service/pedidos",
						method = RequestMethod.GET,
						produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pedido>> retornarPedidosAbertos(){
		List<Pedido> pedidos = pedidoDAO.findAll();
		return new ResponseEntity<List<Pedido>>(pedidos, HttpStatus.OK);
	}

	@RequestMapping(	value = "/service/pedido/fechar/{ordem}",
						method = RequestMethod.GET,
						produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> fecharPerdido(@PathVariable Integer ordem){
		pedidoDAO.fecharPedido(ordem);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
