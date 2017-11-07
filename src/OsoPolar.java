import java.util.ArrayList;

public class OsoPolar extends Animal {

	// La probabilidad de morrir (que es un entero que utilizaremos sobre 1000)
	public static int probabilidadMorir = 95;
	// La probabilidad de Reproducir (que es un entero que utilizaremos sobre 1000)
	public static int probabilidadReproducir = 153;
	
	public OsoPolar(int masaMuscular) {
		super(masaMuscular);
	}
	
	public OsoPolar(Animal animal, int fecha) {
		super(animal, fecha);
	}
	
	public ArrayList comer(){
		ArrayList result = new ArrayList();
		result.add(comerPeces());
		result.add(comerFocas());	
		return result;
	}
	
	public int comerFocas(){
		int nbFocas =  RandomMethods.randomIntInterval(1, 2);
		return nbFocas;
	}
	
	public int comerPeces(){
		int nbPeces =  RandomMethods.randomIntInterval(10, 15);
		return nbPeces;
	}

	@Override
	public int getProbabilidadMorir() {
		return probabilidadMorir;
	}

	@Override
	public int getProbabilidadReproducir() {
		return probabilidadReproducir;
	}

}
