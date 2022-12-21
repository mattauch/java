package com.softgraf.primavera.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.softgraf.primavera.data.entity.Produto;
import com.softgraf.primavera.data.repository.ProdutoRepository;

@Service
public class CrudService {

	private final ProdutoRepository produtoRepository;
	
	
	//construtor padrão
	public CrudService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public void cadastra3Produtos() {
		Produto p1 = new Produto("Telefone", 69.80f, 10, "telefone.jpg");
		Produto p2 = new Produto("Geladeira", 1599.90f, 15, "geladeira.jpg");
		Produto p3 = new Produto("Fogão", 559.60f, 18, "fogao.png");
		
		produtoRepository.save(p1);
		produtoRepository.save(p2);
		produtoRepository.save(p3);
		System.out.println("======= 3 produtos salvos =======");
	}
	
	
	public void cadastraNovoProduto() {
		Scanner scanner = new Scanner(System.in);
		Produto p = new Produto();
		
		System.out.println("Descrição: ");
		p.setDescricao(scanner.nextLine());
		
		System.out.println("Preço: ");
		p.setPreco(scanner.nextFloat());
		
		System.out.println("Quantidade: ");
		p.setQuantidade(scanner.nextInt());
		
		produtoRepository.save(p);
		System.out.println("Produto Salvo!");
		
	}
	
	public void cadastra100ProdutosAleatorios() {
		for (int i=1; i<=100; i++) {
			
			Produto p = new Produto();
			// 7 é o tamanho da palavra randomica
			p.setDescricao(randomTexto(7)); //"abcdefg" = descrição aleatória
			p.setPreco((float) Math.random() *100); //gera um número entre 0 ..100
			p.setQuantidade(1+(int) (Math.random()*30));
			
			produtoRepository.save(p);
			System.out.printf("\nProduto %d/100 salvo", i);
		}
	}
	
	private String randomTexto (int tamanho) {
		StringBuilder builder = new StringBuilder(); //builder =>"" - cria String vazia
		int base = 97; //"a"
		for (int i=0; i<tamanho; i++) {
			//            (char) -> converte int em char
			//                    97 + 0 .. 26 => a..z
			char letra = (char) (base +(Math.random() *26));
			builder.append(letra);
		}
		return builder.toString();
	}
	
	public void listaTodosProdutos() {
		System.out.println("\n\n===== Listando todos os produtos =====");
		List<Produto> todos = produtoRepository.findAll();
		todos.forEach(System.out::println);	
	}
	
	public void listaProdutoComPaginacao() {               //nome do campo da entidade
		Pageable paginacao = PageRequest.of(0, 20, Sort.by("preco").ascending());
		
		Page<Produto> pagina = produtoRepository.findAll(paginacao);
		System.out.println("\n\nTotal de páginas: " + pagina.getTotalPages());  //0..n
		System.out.println("\n\nPágina atual " + pagina.getNumber());
		System.out.println("\n\nItens por página: " + pagina.getSize()); //0..n
		System.out.println("\n\nTotal de itens por consulta: " + pagina.getTotalElements());
		
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		
		do {
			System.out.println("\n\n==== Menu de Paginação ====");
			System.out.println("MOSTRAR = mostra conteúdo da página atual");
			System.out.println("PROX = vai para a próxima página");
			System.out.println("ANT = vai para a página anterior");
			System.out.println("PRI = vai para a primeira página ");
			System.out.println("ULT = vai para a última página");
			System.out.println("CONV = converte página em lista");
			System.out.println("FIM = sai do menu ");
			System.out.println("Qual opção?");
			escolha = scanner.next().toUpperCase();
			
			if(escolha.equals("FIM")) {
				System.out.println("\nSaiu do Menu.");
				break;
			}
			switch (escolha) {
			case "MOSTRAR":
				System.out.println("\n\n----- Exibindo página: " + pagina.getNumber());
				pagina.forEach(System.out::println);
				break;
				
			case "PROX":
				if(pagina.hasNext() ) { //tem a próxima página?
					pagina = produtoRepository.findAll(pagina.nextPageable());
					System.out.println("\n\n***Foi para a página: " + pagina.getNumber());
					
				}else {
					System.out.println("\n***Não há próxima página");
				}
				break;
				
			case "ANT":
				if(pagina.hasPrevious() ) { //tem a próxima página?
					pagina = produtoRepository.findAll(pagina.previousPageable());
					System.out.println("\n\n***Foi para a página: " + pagina.getNumber());
					
				}else {
					System.out.println("\n***Não há página anterior");
				}
				break;
				
			case "PRI":
				pagina = produtoRepository.findAll(paginacao.first());
				System.out.println("\n\n***Foi para a página: " + pagina.getNumber());
				break;
			
			case "ULT":
				paginacao = PageRequest.of(pagina.getTotalPages() -1, 20, Sort.by("id").ascending());
				pagina = produtoRepository.findAll(paginacao);
				System.out.println("\n\n***Foi para a página: " + pagina.getNumber());
				break;
				
			case "CONV":
				List<Produto> lista = pagina.getContent();
				System.out.println("List<Empresa> lista = pagina.getContent();");
				break;
				
			default:
				System.out.println("\n***Opção inválida!***");
				break;
			}
			
			
		}while (true);
			
		}
	}
	
