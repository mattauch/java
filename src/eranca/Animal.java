package eranca;

// classe com atributos privados com todos os getters e setters
// classe POJO
// classe m�e ou superclasse

abstract public class Animal {

//	atributos, vari�veis ou propriedades da classe = substantivo
	private String especie = "mamifero";
	private String tamanho;
	private boolean faminto;

//	m�todos, fun��es ou comportamentos = verbo
//	m�todo abstrato = precisa ser implementado na classe filha
//	existe apenas a declara��o do m�todo
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
