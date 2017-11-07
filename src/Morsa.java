import java.util.ArrayList;

public class Morsa extends Animal{


	// La probabilidad de morrir (que es un entero que utilizaremos sobre 1000)
	public static int probabilidadMorir = 90;
	// La probabilidad de Reproducir (que es un entero que utilizaremos sobre 1000)
	public static int probabilidadReproducir = 10;
	
	public Morsa(int masaMuscular) {
		super(masaMuscular);
	}

	public Morsa(Animal animal, int fecha) {
		super(animal, fecha);
	}
	
	public  int getProbabilidadMorir() {
		return probabilidadMorir;
	}

	public int getProbabilidadReproducir() {
		return probabilidadReproducir;
	}
	
	public ArrayList comer(){
		ArrayList result = new ArrayList();
		result.add(comerOsosPolares());
		result.add(comerFocas());
		return result;
	}
	
	public int comerOsosPolares(){
		int nbPeces =  RandomMethods.randomInt(2);
		return nbPeces;
	}
	
	public int comerFocas(){
		int nbFocas =  RandomMethods.randomIntInterval(1,2);
		return nbFocas;
	}

}
