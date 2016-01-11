package br.com.pizzaria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pizzaria.dao.BebidaDAO;
import br.com.pizzaria.model.Bebida;

@Controller
public class BebidaController {

	@Autowired BebidaDAO bebidaDAO;

	@RequestMapping(value = "/bebidas", method = RequestMethod.GET)
	public @ResponseBody List<Bebida> getSabores(){
		List<Bebida> bebidas = new ArrayList<>();
		bebidas.addAll( bebidaDAO.findAll() );
		return bebidas;
	}

}
