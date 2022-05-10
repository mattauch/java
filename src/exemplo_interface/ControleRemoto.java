package exemplo_interface;

// uma interface é uma classe 100% abstrata
// ou seja, todos os métodos são implicitantes abstratos
// você pode interpretar uma interface como sendo um contrato

public interface ControleRemoto {
	
//	interfaces podem conter apenas constantes
	String BATERIA = "3V";
	
//	métodos implicitantes público e abstrato
	void mudarCanal (int canal);
	void aumentarVolume (int taxa);
	void diminuirVolume (int taxa);
	boolean ligar();
	boolean desligar();

}
