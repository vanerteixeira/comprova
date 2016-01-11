package br.com.pizzaria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pizzaria.dao.SobremesaDAO;
import br.com.pizzaria.model.Sobremesa;

@Controller
public class SobremesaController {

	@Autowired SobremesaDAO sobremesaDAO;

	@RequestMapping(value = "/sobremesas", method = RequestMethod.GET)
	public @ResponseBody List<Sobremesa> getSabores(){
		List<Sobremesa> sobremesas = new ArrayList<>();
		sobremesas.addAll( sobremesaDAO.findAll() );
		return sobremesas;
	}

}
