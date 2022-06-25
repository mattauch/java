package com.softgra.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//NUNCA importa do hibernete
@Entity
public class Cliente {

	private Integer id;

	private String nome; //VARCHAR(255)

	private Endereco endereco;
	
	private List<Pedido> pedidos;
	

	public Cliente() {
		pedidos = new ArrayList<Pedido>();
	}
	

	public Cliente(String nome, Endereco endereco) {
		this();
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public void addPedido(Pedido p) {
		pedidos.add(p);
	}

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)// se remover o cliente, remove demais informações relacionadas 
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@OneToOne(cascade = CascadeType.ALL) // relacionamento de cliente com endereco
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Id // pode ser utilizado no atributo (private Integer id; ou no get - NUNCA NO SET
	@GeneratedValue(strategy = GenerationType.AUTO) // auto-incremento
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 45)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	//para imprimir pedidos na listagem
	public String toString() {
	return String.format("ID: %-5d Nome: %s",id,nome );	
	}

}
