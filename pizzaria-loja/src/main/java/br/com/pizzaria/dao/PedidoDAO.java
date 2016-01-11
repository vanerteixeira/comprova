package br.com.pizzaria.dao;

import java.util.List;

import br.com.pizzaria.model.Pedido;

public interface PedidoDAO {

	List<Pedido> findAll();

	Pedido findById(Integer id);

	void save(Pedido obj);

	Integer gerarNovoPedido();
	
	void fecharPedido(Integer ordem);
}
