import java.io.Serializable;
import java.util.ArrayList;

public abstract class Animal implements Serializable{

	public int fechaNacimiento;
	
	public int masaMuscular;
	
	//Constructor para los animales del principio del juego
	public Animal(int masaMuscular) {
		this.masaMuscular = masaMuscular;
		this.fechaNacimiento = 1;
	}
	
	//Constructor for the reproduction
	public Animal(Animal animal, int fecha){
		this.masaMuscular = animal.getMasaMuscular();
		this.fechaNacimiento = fecha;
	}

	public int getMasaMuscular() {
		return masaMuscular;
	}
	
	public abstract ArrayList comer();
	
	public boolean reproducir(){
		int result = RandomMethods.randomIntInterval(1, 1000);
		if(result <= getProbabilidadReproducir()){
			return true;
		}else{
			return false;
		}
	}
	
	
	public boolean morrir(){
		int result = RandomMethods.randomIntInterval(1, 1000);
		if(result <= getProbabilidadMorir()){
			return true;
		}else{
			return false;
		}
	}
	
	public abstract int getProbabilidadMorir();
	
	public abstract int getProbabilidadReproducir();

	@Override
	public String toString() {
		return this.getClass().getName() + " [fechaNacimiento=" + fechaNacimiento + ", masaMuscular=" + masaMuscular + "] \n";
	}

	
	
	
}
