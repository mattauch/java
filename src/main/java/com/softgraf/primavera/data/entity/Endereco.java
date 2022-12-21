package com.softgraf.primavera.data.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Embeddable
public class Endereco {

	@Column(length = 30)
	private String rua;
	
	@NotBlank(message = "Cidade é obrigatória!")
	@Size(min=3, max=30)
	@Column(length = 30, nullable = false)
	private String cidade;
	
	@Column(length = 20, nullable = false)
	private String bairro;
	
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@NotBlank(message = "Estado é obrigatório!")
	@Column(length = 20, nullable = false)
	private String estado;
	
	@Column(length = 9)
	private String cep;
	
	// -----getters and setters ---------

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
}
