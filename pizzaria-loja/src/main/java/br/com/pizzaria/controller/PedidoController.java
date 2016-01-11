package br.com.pizzaria.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.pizzaria.dao.PedidoDAO;
import br.com.pizzaria.model.Pedido;

@Controller
public class PedidoController {

	@Autowired private PedidoDAO pedidoDAO;

	@RequestMapping(value = "/pedido", method = RequestMethod.GET)
	public String index(){
		return "pedido/index";
	}

	@RequestMapping(value = "/pedido/finalizar", 
					method = RequestMethod.POST,
					consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> finalizarPedido(@RequestBody Pedido pedido){
		pedido.setData(new Date());
		pedido.setOrdem( pedidoDAO.gerarNovoPedido() );
		pedidoDAO.save(pedido);
		return new ResponseEntity<Integer>(pedido.getOrdem(), HttpStatus.OK);
	}
	
}