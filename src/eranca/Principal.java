package eranca;

public class Principal {

	public static void main(String[] args) {

		Gato gato = new Gato();
		gato.setEspecie("mam�fero");
		System.out.println(gato.getEspecie());

//		casting - convers�o tempor�ria
		 gato.miar();
		gato.miar("Miau miau ....");
		
		
//		se comporta como um animal por�m � um c�o
		Animal cao = new Cao();
		((Cao)cao).latir();
		
		Leao leao = new Leao();
		leao.rugir();
	
		leao.deslocar();

	}

}
