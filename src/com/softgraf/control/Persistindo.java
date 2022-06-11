package com.softgraf.control;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.softgra.entity.Cliente;
import com.softgra.entity.Endereco;
import com.softgra.entity.Item;
import com.softgra.entity.Pedido;
import com.softgra.entity.Produto;

public class Persistindo {

	public static void main(String[] args) {
		
		Endereco ruaXV = new Endereco("Rua XV de novembro, 123","Ponta Grossa","Paraná" );
		
		Cliente joao = new Cliente("João da Silva",ruaXV);
		
		Pedido ped = new Pedido();
		ped.setCliente(joao);
		ped.setData(new Date());
		
		Produto bolacha = new Produto();
		bolacha.setNome("Bolacha Maria");
		bolacha.setPreco(5.99f);
		
		Produto balas = new Produto();
		balas.setNome("Bala 7 Belo");
		balas.setPreco(7.50f);
		
		Item item1 = new Item();
		item1.setPedido(ped);
		item1.setProduto(bolacha);
		item1.setQuantidade(10); //10 pacotes de bolacha
		
		Item item2 = new Item();
		item2.setPedido(ped);
		item2.setProduto(balas);
		item2.setQuantidade(3); //3 pacotes de bala
		
		ped.addItem(item1);
		ped.addItem(item2);
		
		joao.addPedido(ped);
		
		
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("softgraf_pu");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		//se tiver a entity a tabela é criada, porém precisa do em.persist pra gravar os dados na tabela
		tx.begin(); //inicia uma transação (bando de dados).Quando vai fazer uma operação no banco de dados se inicia uma transação
		
		em.persist(joao);//é objeto que vai gravar no banco
		
		tx.commit();//confirma a transação
		
		em.close();
		
		emf.close();
	}

}
