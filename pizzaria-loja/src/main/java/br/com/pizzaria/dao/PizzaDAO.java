package br.com.pizzaria.dao;

import java.util.List;

import br.com.pizzaria.model.Pizza;

public interface PizzaDAO {

	List<Pizza> findAll();

	Pizza findById(Integer id);

	void save(Pizza obj);

}
