package com.softgraf.dao;

import java.util.ArrayList;
import java.util.List;

// classe javabean
// javabean: é um pojo com um construtor padrão
public class ContatoDAO {

	private List<Contato> lista;
	
	public ContatoDAO() {
		this.lista = new ArrayList<Contato>();
		lista.add(new Contato(1, "João da Silva", "(42) 98402-1234"));
		lista.add(new Contato(2, "Maria da Silva", "(42) 98402-5678"));
		lista.add(new Contato(3, "Carlos da Silva", "(42) 98402-9876"));
	}
	
	public List<Contato> getLista() {
		return lista;
	}
	
	public void addContato(Contato contato) {
		this.lista.add(contato);
	}
	
}
