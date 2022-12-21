package com.softgraf.primavera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.softgraf.primavera.data.entity.Produto;
import com.softgraf.primavera.data.repository.ProdutoRepository;

@Controller
public class HomeController {

	@Autowired
	private ProdutoRepository repository;

	@GetMapping("home") // localhost:8080/home
	public String home(Model model) {
		List<Produto> produtos = repository.findAll();

		// objeto responsável por enviar os dados para o front end
		model.addAttribute("produtos", produtos);
		model.addAttribute("uploads", "/uploads/");

		// Carrega templates/home.html
		return "home";
	}

	@GetMapping("/sobre")
	public String sobre(Model model) {
		return "sobre";
	}

	@GetMapping("/")
	public String index(Model model) {
		return "redirect:/home";
	}

}
