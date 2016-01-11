package br.com.pizzaria.dao;

import java.util.List;

import br.com.pizzaria.model.Sabor;

public interface SaborDAO {

	List<Sabor> findAll();

	Sabor findById(Integer id);

	void save(Sabor obj);

}
