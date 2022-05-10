package exemplo_interface;

// uma interface � uma classe 100% abstrata
// ou seja, todos os m�todos s�o implicitantes abstratos
// voc� pode interpretar uma interface como sendo um contrato

public interface ControleRemoto {
	
//	interfaces podem conter apenas constantes
	String BATERIA = "3V";
	
//	m�todos implicitantes p�blico e abstrato
	void mudarCanal (int canal);
	void aumentarVolume (int taxa);
	void diminuirVolume (int taxa);
	boolean ligar();
	boolean desligar();

}
