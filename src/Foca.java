import java.util.ArrayList;

public class Foca extends Animal{


	// La probabilidad de morrir (que es un entero que utilizaremos sobre 1000)
	public static int probabilidadMorir;
	// La probabilidad de Reproducir (que es un entero que utilizaremos sobre 1000)
	public static int probabilidadReproducir;
	
	public Foca(int masaMuscular) {
		super(masaMuscular);
	}

	public Foca(Animal animal, int fecha) {
		super(animal, fecha);
	}

	public ArrayList comer(){
		ArrayList result = new ArrayList();
		int nbPeces = RandomMethods.randomIntInterval(15,25);
		result.add(nbPeces);
		return result;
	}
	
	public  int getProbabilidadMorir() {
		return probabilidadMorir;
	}

	public int getProbabilidadReproducir() {
		return probabilidadReproducir;
	}
	
}
