package eranca;

// classe com atributos privados com todos os getters e setters
// classe POJO
// classe mãe ou superclasse

abstract public class Animal {

//	atributos, variáveis ou propriedades da classe = substantivo
	private String especie = "mamifero";
	private String tamanho;
	private boolean faminto;

//	métodos, funções ou comportamentos = verbo
//	método abstrato = precisa ser implementado na classe filha
//	existe apenas a declaração do método
	abstract public void deslocar ();
	
	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public boolean isFaminto() {
		return faminto;
	}

	public void setFaminto(boolean faminto) {
		this.faminto = faminto;
	}

}
