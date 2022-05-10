package arquivos;

import java.time.LocalDate;
import java.util.Date;

public class Operacao {
	private String identificador;
	private String data;
	private double valor;
	private String descricao;
	private TipoOperacao tipo;

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}


	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoOperacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoOperacao tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		
		return String.format("%s \tR$ %.2f", data, Math.abs(valor));
	}

}
