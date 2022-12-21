package com.softgraf.primavera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softgraf.primavera.data.entity.Produto;
import com.softgraf.primavera.data.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/api")
public class ProdutoApiController {

	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping("/produtos")
	public List<Produto>listarTodos(){
		return repository.findAll();
	}
	
	//salva um único produto
	@PostMapping("/produtos")
	public Produto salvar(@RequestBody Produto novoProduto) {
		return repository.save(novoProduto);
	}
	
}
