package eranca;

// � UM = extends

public class Gato extends Felino {
	
//	quando temos dois m�todos com o mesmo nome, na mesma classe, por�m com assinaturas diferentes, dizemos que temos uma sobrecarga de m�todos
	public void miar () {
	System.out.println("MEAW ....");
}

	public void miar (String miado) {
		System.out.println(miado);
	}

	@Override
	public void deslocar() {
		System.out.println("Gato correndo ...");
		
	}
	
	
	
	
	

}
