package com.softgraf.primavera.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softgraf.primavera.data.entity.Produto;
import com.softgraf.primavera.data.repository.ProdutoRepository;

@Controller
@RequestMapping("produto") // localhost:8080/produto
public class ProdutoController {

	// localhost:8080/home
	// localhost:8080/sobre

	// localhost:8080/produto/cadastrar
	// localhost:8080/produto/excluir
	// localhost:8080/produto/listar

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ApplicationContext applicationContext;

	// localhost:8080/produto/gerenciar
	@GetMapping("/gerenciar")
	public ModelAndView gerenciar(ModelAndView mv) {
		List<Produto> produtos = produtoRepository.findAll();
		mv.addObject("produtos", produtos);
		mv.getModelMap().addAttribute("uploads", "/uploads/");
		mv.setViewName("/produto/gerenciar");
		return mv; // "templates/produto/gerenciar.html"
	}

	// http://localhost:8080/produto/cadastrar
	@GetMapping("cadastrar")
	public ModelAndView cadastrar(ModelAndView mv) {
		mv.addObject("imagens", listarImagensDeUploads());
		mv.setViewName("produto/cadastrar");

		return mv; // templates/produto/cadastrar.html
	}
	
	private List<String> listarImagensDeUploads() {
		List<String> lista = new ArrayList<>();
		
		try { 
			Resource[] resources = applicationContext.getResources("file:uploads/"); //devolve um vetor
			
			for(Resource res : resources) 
				lista.add(res.getFilename());
				
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		
		return lista;
	}

	// http://localhost:8080/produto/excluir/805
	@GetMapping("excluir/{id}")
	public String excluir(@PathVariable Long id) {
		produtoRepository.deleteById(id);
		return "redirect:/produto/gerenciar";
	}

}
