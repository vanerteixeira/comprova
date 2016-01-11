package br.com.pizzaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LojaController {

	@RequestMapping(value = "/loja", method = RequestMethod.GET)
	public String index(){
		return "loja/index";
	}
	
}
