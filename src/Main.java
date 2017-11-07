import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static Polo polo = null;
	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		
		
		
		
		Polo polo = new Polo();
		GUIClass appWindow = new GUIClass();
		Animal animal = new Bacalao(12);
		if(animal instanceof Pez){
			System.out.println(animal);
		}
		/**Animal animal = new Pez(12);
		
		
		ArrayList list = new ArrayList();
		list.add(new Pez(12));
		list.add(new Pez(12));
		System.out.println(list);
		**/
		System.out.println(polo.getMorsas().size());
		System.out.println(polo.getNbMorsas());
		System.out.println(animal);
		
		//*
	//	polo.mostrarDetalles();
		//polo.transcurrirUnDia();
	//	polo.mostrarDetalles();
	//	polo.transcurrirUnDia();
	//	polo.mostrarDetalles();
	//	polo.transcurrirUnDia();
	//	polo.mostrarDetalles();
	//	/*
	}
	
}
