package com.softgra.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {

	private Integer id;
	private Date data;
	private Cliente cliente;
	private List<Item> itens;
	
	public Pedido() {
	  itens = new ArrayList<Item>();
	}
	
	public void addItem(Item item) {
		itens.add(item);
	}
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	//para imprimir pedidos na listagem
	public String toString() {
	return String.format("ID: %-5d Data: %s Cliente: %s", id, data, cliente.getNome());	
	}
}
