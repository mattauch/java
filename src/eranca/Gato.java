package eranca;

// É UM = extends

public class Gato extends Felino {
	
//	quando temos dois métodos com o mesmo nome, na mesma classe, porém com assinaturas diferentes, dizemos que temos uma sobrecarga de métodos
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
