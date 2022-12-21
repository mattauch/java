package com.softgraf.primavera.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	/*
	//cria uma rota para o navegador
	//localhost:8080/hello
	//este método é uma Action que atende uma requesição http 
	@GetMapping("/hello")
	public String hello(HttpServletRequest request) {
	
		//Usa uma requisição httpServlet para salvar dados para o front-end
		request.setAttribute("nome", "João da Silva");
		
		//retorna o hello.html para o navegador
		return "hello";
	}*/

	@GetMapping("/hello")
	//a Action hello recebe um objeto Model que representa os dados para o fron-end
	public String hello(Model model) {
		model.addAttribute("nome", "Amanda Mattauch");
		return "hello";
		
	}
	
	
}
