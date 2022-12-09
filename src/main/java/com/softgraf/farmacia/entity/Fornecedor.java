package com.softgraf.farmacia.entity;

import java.io.Serializable;

/*
 * Qualquer calsse publica que possua um costrutor padrão ou um construtor com argumentos injetados
 * Passa a ser um Bean CDI (CDI Managed Bean)
 * Então se faz necessário a anotação @Named do CDI em todos os casos
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Fornecedor implements Serializable{

	private static final long serialVersionUID = 712581365598127439L;
	
	private Integer id;
	private String razaoSocial;
	private String cnpj;
	private String email;
	private String fone;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotEmpty // hibernate validator --> não fica gravado na tabela, somente no momento de
				// excução
	@Size(min = 3, max = 60) // hibernate validator
	@Column(length = 60, nullable = false)
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Column(length = 18)
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Size(max = 60) // hibernate validator
	@Column(length = 60)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 14)
	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	@Column(length = 30)
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	@Column(length = 20)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@NotEmpty
	@Size(min = 3, max = 30)
	@Column(length = 30, nullable = false)
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@NotEmpty
	@Column(length = 20, nullable = false)
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Column(length = 9)
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}