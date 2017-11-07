import java.util.ArrayList;

public class Pez extends Animal {


	// La probabilidad de morrir (que es un entero que utilizaremos sobre 1000)
	public static int probabilidadMorir = 163;
	// La probabilidad de Reproducir (que es un entero que utilizaremos sobre 1000)
	public static int probabilidadReproducir = 185;
	
	public Pez(int masaMuscular) {
		super(masaMuscular);
	}

	public Pez(Animal animal, int fecha) {
		super(animal, fecha);
	}

	public ArrayList comer(){
		ArrayList result = new ArrayList();
		int nbKrill = RandomMethods.randomIntInterval(1,2);
		result.add(nbKrill);
		return result;
	}
	public  int getProbabilidadMorir() {
		return probabilidadMorir;
	}

	public int getProbabilidadReproducir() {
		return probabilidadReproducir;
	}
	
	@Override
	public String toString() {
		return " Pez : " + super.toString();
	}
	
}
