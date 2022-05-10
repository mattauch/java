package exemplo_interface;

public class TvSamsung extends Tv implements ControleRemoto {

	public TvSamsung() {
		super (50);
	}
	
	@Override
	public void mudarCanal(int canal) {
	System.out.println("Mudando de canal..." + canal);
		
	}

	@Override
	public void aumentarVolume(int taxa) {
		System.out.println("Aumentando volume em..." + taxa + "%");
		
	}

	@Override
	public void diminuirVolume(int taxa) {
		System.out.println("Diminuindo volume em..." + taxa + "%");
		
	}

	@Override
	public boolean ligar() {
		System.out.println("Ligando TV");
		return true;
	}

	@Override
	public boolean desligar() {
		System.out.println("Desligado TV");
		return false;
	}
	
	

}
