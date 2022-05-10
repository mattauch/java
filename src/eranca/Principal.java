package eranca;

public class Principal {

	public static void main(String[] args) {

		Gato gato = new Gato();
		gato.setEspecie("mamífero");
		System.out.println(gato.getEspecie());

//		casting - conversão temporária
		 gato.miar();
		gato.miar("Miau miau ....");
		
		
//		se comporta como um animal porém é um cão
		Animal cao = new Cao();
		((Cao)cao).latir();
		
		Leao leao = new Leao();
		leao.rugir();
	
		leao.deslocar();

	}

}
