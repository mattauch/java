package com.softgraf.primavera;


import java.util.Locale;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import com.softgraf.primavera.service.CrudService;

@SpringBootApplication
//caso o spring não encontre os respositórios
//@EnableJpaRepositories(basePackages = "com.softgraf.primavera.data.repository")
public class PrimaveraApplication implements CommandLineRunner {

	private final CrudService crudService;
	
	public PrimaveraApplication(CrudService crudService) {
		this.crudService = crudService;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(PrimaveraApplication.class, args);
	}
	
	
	/*
	 * método da interface CommandLineRunner
	 * Executado na finalização do método main()
	 * usado para testar os repositorios, sem necessitar do front-end
	 */

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Está rodando");
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
		
		System.out.println("\n\n=========sistema primavera=================");
		
		System.out.println("1= cadastrar 3 produtos padrões");
		
		System.out.println("2= cadastrar novo produto");
		
		System.out.println("3= cadastrar 100 produtos aleatórios");
		
		System.out.println("4= listar todos os produtos");
		
		System.out.println("5= Listar todos os produtos com paginação (20/página) e ordem ascendente");
		
		System.out.println("6= busca produto por destrição");
		
		System.out.println("Qual opção?");
		int opcao = scanner.nextInt();
		
		switch (opcao) {
		case 1: {
			crudService.cadastra3Produtos();
			break;
		}
		case 2: {
			crudService.cadastraNovoProduto();
			break;
		}
		
		case 3: {
			crudService.cadastra100ProdutosAleatorios();
			break;
		}
		
		case 4: {
			crudService.listaTodosProdutos();
			break;
		}
		
		case 5: {
			crudService.listaProdutoComPaginacao();
			break;
		}
		
		case 6: {
			break;
		}
		
		default:
			System.out.println("Opção inválida.");
		}
		}
	}

}
