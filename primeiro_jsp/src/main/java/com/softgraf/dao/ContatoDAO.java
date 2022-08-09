package com.softgraf.dao;

import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

	private List<Contato> lista;
	
	public ContatoDAO() {
		this.lista = new ArrayList<>();
		lista.add(new Contato(1, "João da Silva", "(42) 98402-1234"));
		lista.add(new Contato(2, "Maria da Silva", "(42) 98402-4567"));
		lista.add(new Contato(3, "Carlos da Silva", "(42) 98402-3890"));
	}
	
	public List<Contato> getLista() {
		return this.lista;
	}
	
	public void addContato(Contato contato) {
		this.lista.add(contato);
	}
}
