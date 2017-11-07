import java.util.ArrayList;

public class Esquimal extends Animal {

	// La probabilidad de morrir (que es un entero que utilizaremos sobre 1000)
	public static int probabilidadMorir = 24;
	// La probabilidad de Reproducir (que es un entero que utilizaremos sobre 1000)
	public static int probabilidadReproducir = 32;
	
	public Esquimal(int masaMuscular) {
		super(masaMuscular);
	}
	
	public Esquimal(Animal animal, int fecha) {
		super(animal, fecha);
	}
	
	@Override
	public ArrayList comer() {
		ArrayList result = new ArrayList();
		result.add(comerPeces());
		result.add(comerFocas());
		return result;
	}
	
	public int comerPeces(){
		int nbPeces =  RandomMethods.randomIntInterval(2,4);
		return nbPeces;
	}
	
	public int comerFocas(){
		int nbFocas =  RandomMethods.randomInt(1);
		return nbFocas;
	}

	public  int getProbabilidadMorir() {
		return probabilidadMorir;
	}

	public int getProbabilidadReproducir() {
		return probabilidadReproducir;
	}
	
	


	
	
}
