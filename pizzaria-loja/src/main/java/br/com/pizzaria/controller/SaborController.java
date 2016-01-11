package br.com.pizzaria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pizzaria.dao.SaborDAO;
import br.com.pizzaria.model.Sabor;

@Controller
public class SaborController {

	@Autowired SaborDAO saborDAO;

	@RequestMapping(value = "/sabores", method = RequestMethod.GET)
	public @ResponseBody List<Sabor> getSabores(){
		List<Sabor> sabores = new ArrayList<>();
		sabores.addAll( saborDAO.findAll() );
		return sabores;
	}

}
