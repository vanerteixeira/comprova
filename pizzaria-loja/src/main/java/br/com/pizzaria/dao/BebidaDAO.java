package br.com.pizzaria.dao;

import java.util.List;

import br.com.pizzaria.model.Bebida;

public interface BebidaDAO {

	List<Bebida> findAll();

	Bebida findById(Integer id);

	void save(Bebida obj);

}
