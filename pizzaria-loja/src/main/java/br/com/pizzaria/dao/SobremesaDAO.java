package br.com.pizzaria.dao;

import java.util.List;

import br.com.pizzaria.model.Sobremesa;

public interface SobremesaDAO {

	List<Sobremesa> findAll();

	Sobremesa findById(Integer id);

	void save(Sobremesa obj);

}
